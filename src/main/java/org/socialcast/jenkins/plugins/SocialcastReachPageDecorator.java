package org.socialcast.jenkins.plugins;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.Util;
import hudson.model.PageDecorator;

@Extension
public class SocialcastReachPageDecorator extends PageDecorator {
	private String token;
    private String domain;
    
    @DataBoundConstructor
    public SocialcastReachPageDecorator(String token, String domain) {
        this();
        this.setToken(token);
        this.setDomain(domain);
    }
    
    public SocialcastReachPageDecorator() {
        super(SocialcastReachPageDecorator.class);
        load();
    }
    
    @Override
    public String getDisplayName() {
        return "Socialcast Reach";
    }
    
    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        req.bindJSON(this, json);
        save();
        return true;
    }

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return Util.fixEmpty(token);
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDomain() {
		return Util.fixEmpty(domain);
	}

    
}
