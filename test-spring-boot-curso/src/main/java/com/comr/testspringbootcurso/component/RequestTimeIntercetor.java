package com.comr.testspringbootcurso.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeIntercetor")
public class RequestTimeIntercetor extends HandlerInterceptorAdapter{

	private Log LOG = LogFactory.getLog(RequestTimeIntercetor.class);
	
	//se ejecuta antes de entrar al metodo del controlador
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//return super.preHandle(request, response, handler);
		
		request.setAttribute("tiempoInicio", System.currentTimeMillis());
		return true;
	}
	
	//es el que se ejecuta justo cuando termina el controlador, antes de escupir la vista en el navegador
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		//super.afterCompletion(request, response, handler, ex);
		
		long tiempoInicio = (long)request.getAttribute("tiempoInicio");
		LOG.info("---URL:" + request.getRequestURL().toString() + 
				", tiempo que tado en responder:" + (System.currentTimeMillis() - tiempoInicio) + " ms");
		
	}


	
	
}
