package com.threesome.timeTrackingService.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseFilter extends HttpServletResponseWrapper {


    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response The response to be wrapped
     * @throws IllegalArgumentException if the response is null
     */
    public ResponseFilter(HttpServletResponse response) {
        super(response);
    }

}

