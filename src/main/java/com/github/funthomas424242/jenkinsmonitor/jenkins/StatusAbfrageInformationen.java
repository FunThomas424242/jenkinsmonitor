package com.github.funthomas424242.jenkinsmonitor.jenkins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

public class StatusAbfrageInformationen {

    protected final Logger LOGGER = LoggerFactory.getLogger(StatusAbfrageInformationen.class);

    protected final URL jenkinsJobUrl;
    protected final String userName;
    protected final String password;

    public StatusAbfrageInformationen(final URL jenkinsJobUrl, final String userName, String password) {
        this.jenkinsJobUrl = jenkinsJobUrl;
        this.userName = userName;
        this.password = password;
    }

    public URL getStatusAbfrageUrl() {
        try {
            return new URL(jenkinsJobUrl.toExternalForm() + JenkinsAPI.STATUS_PATH);
        } catch (MalformedURLException e) {
            LOGGER.error("Generierter Statusabfrage URL ist ungültig", e);
        }
        return null;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getBasicAuthToken(String password) {
        String encodedToken = null;
        try {
            if (password != null && password.equals(this.password)) {
                encodedToken = Base64.getEncoder().encodeToString(String.format("%s:%s", this.userName, password).getBytes("utf-8"));
            }
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Nichtunterstütztes Encoding utf-8 für das Verschlüsseln der Zugangsdaten angefordert");
        }
        return encodedToken;
    }
}
