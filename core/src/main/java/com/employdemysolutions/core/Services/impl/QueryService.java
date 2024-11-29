package com.employdemysolutions.core.Services.impl;



import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.employdemysolutions.core.models.QueryBuilderCom;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(service = QueryService.class)
public class QueryService {

    @Reference
    private QueryBuilder queryBuilder;

    @Reference
    private ModelFactory modelFactory;

    public List<String> fetchPages(Resource resource) {
        List<String> pagePaths = new ArrayList<>();
        List<Resource> refPage = new ArrayList<>();

        try {
            QueryBuilderCom queryModel = resource.adaptTo(QueryBuilderCom.class);
            if (queryModel == null) {
                throw new IllegalArgumentException("Failed to adapt resource to QueryBuilderCom model!");
            }

            // Extract parameters from the model
            String path = queryModel.getPathField();
            List<String> tags = queryModel.getTag();

            // Build query map
            Map<String, String> queryMap = new HashMap<>();
            queryMap.put("type", "cq:Page");
            queryMap.put("path", path);
             
            // checking the tags
            if (tags != null && !tags.isEmpty()) {
                queryMap.put("property", "jcr:content/cq:tags");
                //using the for loops to add the multiple tags in the map
                for (int i = 0; i < tags.size(); i++) {
                    queryMap.put("property." + (i + 1) + "_value", tags.get(i));
                }
            }

            Session session = resource.getResourceResolver().adaptTo(Session.class);
            //we are using session bca createQuery take 2 parameters predicateGrp and Session
            Query query = queryBuilder.createQuery(PredicateGroup.create(queryMap), session);
            SearchResult result = query.getResult();

            for (Hit hit : result.getHits()) {

                pagePaths.add(hit.getPath());
                refPage.add(hit.getResource());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       //returning the Path of the page
        return pagePaths;
    }
}
