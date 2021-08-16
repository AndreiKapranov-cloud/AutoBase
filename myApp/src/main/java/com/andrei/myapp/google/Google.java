package com.andrei.myapp.google;

import com.andrei.myapp.configuration.AppProperties;

public class Google {
    private final AppProperties appProperties;

    public Google(AppProperties appProperties) throws Exception {
        this.appProperties = appProperties;
    }



    public AppProperties getAppProperties() {
        return appProperties;
    }

    public long getGoogle(String source,String destination) throws Exception {
        GetDistanceMatrixApi getDistanceMatrixApi = new GetDistanceMatrixApi(getAppProperties());
        source = "Minsk";
        destination ="Grodno";
        return getDistanceMatrixApi.getData(source, destination);
    }
}
