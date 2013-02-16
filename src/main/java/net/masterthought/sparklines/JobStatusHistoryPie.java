package net.masterthought.sparklines;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.util.ArrayList;

public class JobStatusHistoryPie extends AbstractPage {

    private File targetBuildDirectory;
    private ArrayList<BuildInformation> jobHistory;
    private String pluginUrlPath;
    private String buildUrl;
    private String jobName;

    public JobStatusHistoryPie(File targetBuildDirectory, ArrayList<BuildInformation> jobHistory, String pluginUrlPath, String buildUrl, String jobName) {
        this.targetBuildDirectory = targetBuildDirectory;
        this.jobHistory = jobHistory;
        this.pluginUrlPath = pluginUrlPath;
        this.buildUrl = buildUrl;
        this.jobName = jobName;
    }

    public void generate() throws Exception {
        VelocityEngine ve = new VelocityEngine();
        ve.init(getProperties());
        Template template = ve.getTemplate("templates/jobStatusHistoryPie.vm");
        VelocityContext context = new VelocityContext();
        context.put("jquery_js_url", pluginUrlPath + "plugin/jenkins-sparklines/jquery-1.9.1.min.js");
        context.put("sparklines_js_url", pluginUrlPath + "plugin/jenkins-sparklines/jquery.sparkline.min.js");
        context.put("pass_fail", passFail());
        context.put("jobName", jobName);
        context.put("buildUrl", buildUrl);
        generateSparkLine("job-status-history-pie.html", targetBuildDirectory, template, context);
    }

    private String passFail() {
        int success = 0;
        int failure = 0;
        int other = 0;
        for (BuildInformation buildInformation : jobHistory) {
            if (buildInformation.getBuildResult() == BuildStatus.SUCCESS.getStatus()) {
                success++;
            } else if (buildInformation.getBuildResult() == BuildStatus.FAILURE.getStatus()) {
                failure++;
            } else {
                other++;
            }
        }
        return success + "," + failure + "," + other;
    }
}
