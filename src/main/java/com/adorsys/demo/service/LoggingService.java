package com.adorsys.demo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface LoggingService {

    public void logRequest(HttpServletRequest httpServletRequest, Object object);

    public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object);


}
