/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package demo.jaxrs.swagger.server;

import java.util.Arrays;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/sample") 
@Api(value = "/sample", description = "Sample JAX-RS service with Swagger documentation")
public class Sample {
    @Produces({ MediaType.APPLICATION_JSON })
    @GET
    @ApiOperation(
        value = "Get operation with Response and @Default value", 
        notes = "Get operation with Response and @Default value", 
        response = Item.class, 
        responseContainer = "List"
    )
    public Response getResponse(
        @ApiParam(value = "Page to fetch", required = true) @QueryParam("page") @DefaultValue("1") int page) {
        return Response.ok(
            Arrays.asList(
                new Item("Item 1", "Value 1"),
                new Item("Item 2", "Value 2")
            )
        ).build();
    }
}
