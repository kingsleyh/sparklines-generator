package net.masterthought.sparklines;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Properties;

public class BuildStatusBasic extends AbstractPage{

    private File targetBuildDirectory;
    private final String buildStatus;
    private final String pluginUrlPath;
    private final String jobPath;

    public BuildStatusBasic(File targetBuildDirectory, String buildStatus, String pluginUrlPath, String jobPath) {
        this.targetBuildDirectory = targetBuildDirectory;
        this.buildStatus = buildStatus;
        this.pluginUrlPath = pluginUrlPath;
        this.jobPath = jobPath;
    }

    public void generate() throws Exception {
        BuildStatus status = BuildStatus.fromStatus(buildStatus);
        VelocityEngine ve = new VelocityEngine();
        ve.init(getProperties());
        Template template = ve.getTemplate("templates/buildStatusBasic.vm");
        VelocityContext context = new VelocityContext();
        context.put("processing_js_url", pluginUrlPath + "plugin/jenkins-sparklines/processing.js");
        context.put("status", status);
        context.put("job_path", pluginUrlPath + jobPath);
        generateSparkLine("build-status.html", targetBuildDirectory, template, context);
    }


}

