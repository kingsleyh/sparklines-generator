package net.masterthought.sparklines;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Properties;

public class BuildStatusJobName {

    private File targetBuildDirectory;
    private final String buildStatus;
    private final String pluginUrlPath;
    private final String jobPath;
    private String jobName;

    public BuildStatusJobName(File targetBuildDirectory, String buildStatus, String pluginUrlPath, String jobPath, String jobName) {
        this.targetBuildDirectory = targetBuildDirectory;
        this.buildStatus = buildStatus;
        this.pluginUrlPath = pluginUrlPath;
        this.jobPath = jobPath;
        this.jobName = jobName;
    }

    public void generate() throws Exception {
        BuildStatus status = BuildStatus.fromStatus(buildStatus);
        int jobNameLength = jobName.length();
        double CHAR_LENGTH = 7.5;
        double itemLength = (jobNameLength * CHAR_LENGTH) + 5;
        int statusLength = 50;
        double canvasLength = itemLength + statusLength + 5;
        VelocityEngine ve = new VelocityEngine();
        ve.init(getProperties());
        Template template = ve.getTemplate("templates/buildStatusJobName.vm");
        VelocityContext context = new VelocityContext();
        context.put("processing_js_url", pluginUrlPath + "plugin/jenkins-sparklines/processing.js");
        context.put("status", status);
        context.put("canvas_length", canvasLength);
        context.put("item_length", itemLength);
        context.put("item_length_ext", itemLength + 5);
        context.put("job_name", jobName);
        context.put("job_path", pluginUrlPath + jobPath);
        generateSparkLine("job-status.html", targetBuildDirectory, template, context);
    }

    private void generateSparkLine(String fileName, File targetBuildDirectory, Template template, VelocityContext context) throws Exception {
        Writer writer = new FileWriter(new File(targetBuildDirectory, fileName));
        template.merge(context, writer);
        writer.flush();
        writer.close();
    }

    private Properties getProperties() {
        Properties props = new Properties();
        props.setProperty("resource.loader", "class");
        props.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return props;
    }

}
