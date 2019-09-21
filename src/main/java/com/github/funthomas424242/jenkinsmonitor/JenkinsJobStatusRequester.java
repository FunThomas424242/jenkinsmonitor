package com.github.funthomas424242.jenkinsmonitor;

/*-
 * #%L
 * Jenkins Monitor
 * %%
 * Copyright (C) 2019 PIUG
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;


public class JenkinsJobStatusRequester {

    public static final String JSONKEY_FULL_DISPLAY_NAME = "fullDisplayName";
    public static final String JSONKEY_RESULT = "result";


    public JobBeschreibung getJobStatus(final URL jenkinsJobURL) throws IOException {
        final URL abfrageURL = new URL(jenkinsJobURL.toExternalForm() + JenkinsAPI.STATUS_PATH);
        final JSONObject resultJSON = sendGetRequest(abfrageURL);
        try {
            final String jobName = resultJSON.getString(JSONKEY_FULL_DISPLAY_NAME);
            final String jobStatus = resultJSON.getString(JSONKEY_RESULT);
            return new JobBeschreibung(jobName, JobStatus.valueOf(jobStatus), jenkinsJobURL);
        } catch (JSONException ex) {
            return new JobBeschreibung(jenkinsJobURL.getPath(), JobStatus.OTHER, jenkinsJobURL);
        }
    }

    public JSONObject sendGetRequest(final URL statusAbfrageUrl) throws IOException {
        JSONObject resultJSON = null;
        try (final CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            final HttpHost target = new HttpHost(statusAbfrageUrl.getHost(), statusAbfrageUrl.getPort(), statusAbfrageUrl.getProtocol());
            final HttpGet httpGetRequest = new HttpGet(statusAbfrageUrl.getPath());
            final HttpResponse httpResponse = httpClient.execute(target, httpGetRequest);
            final HttpEntity entity = httpResponse.getEntity();
            final InputStream inputStream = entity.getContent();

            final String requestResult = readStreamIntoString(inputStream);
            resultJSON = new JSONObject(requestResult);

        }
        return resultJSON;
    }

    protected String readStreamIntoString(InputStream inputStream) throws IOException {
        String requestResult;
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream))) {
            requestResult = buffer.lines().collect(Collectors.joining("\n"));
        }
        return requestResult;
    }


}
