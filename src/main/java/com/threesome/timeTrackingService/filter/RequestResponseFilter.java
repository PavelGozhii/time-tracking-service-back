package com.threesome.timeTrackingService.filter;

import org.apache.logging.log4j.core.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestResponseFilter extends OncePerRequestFilter implements Filter {

    private static Logger LOG = LoggerFactory.getLogger("RequestResponseFilter");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ResponseFilter responseFilter = new ResponseFilter(response);
        String requestBody = IOUtils.toString(request.getReader());
        LOG.info(request.getRequestURI() + " " + requestBody);
        filterChain.doFilter(request, response);
        responseFilter.setHeader("Access-Control-Allow-Origin", "*");
    }

}

