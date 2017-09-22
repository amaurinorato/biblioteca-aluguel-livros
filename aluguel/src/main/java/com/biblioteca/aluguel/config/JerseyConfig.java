/*
 /*
 * Copyright (c) 2017, Riachuelo and/or its affiliates. All rights reserved.
 * RCHLO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.biblioteca.aluguel.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.stereotype.Component;

import com.biblioteca.aluguel.resource.BookResource;
import com.biblioteca.aluguel.resource.CursoResource;
import com.biblioteca.aluguel.resource.UsuarioResource;

@ApplicationPath("/v1")
@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(WadlResource.class);
		register(UsuarioResource.class);
		register(BookResource.class);
		register(CursoResource.class);
	}

}
