/**
 * Copyright (c) 2010-2019 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.netatmo.internal.camera;

import java.io.IOException;
import java.net.URL;

import org.openhab.binding.netatmo.internal.camera.GetHomeDataRequest;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

/**
 * @author Ing. Peter Weiss
 * @since 1.9.0
 */
public class GetHomeDataRequestStub extends GetHomeDataRequest {

    protected static final String ACCESS_TOKEN = "000000000000000000000000|11111111111111111111111111111111";

    public static GetHomeDataRequestStub createRequest(final String resource) throws Exception {
        return new GetHomeDataRequestStub(resource);
    }

    private final String response;

    private String content;

    GetHomeDataRequestStub(final String response) throws Exception {
        super(ACCESS_TOKEN);

        final URL resource = getClass().getResource(response);

        if (resource == null) {
            throw new IOException("Resource '" + response + "' not found!");
        }

        this.response = Resources.toString(resource, Charsets.UTF_8);
    }

    public String getContent() {
        return this.content;
    }

    @Override
    protected String executeQuery(final String content) {
        this.content = content;

        return this.response;
    }

}