package net.masterthought.sparklines;

public class BuildInformation {

    private Integer buildNumber;
    private String buildResult;
    private String duration;

    public BuildInformation(Integer buildNumber, String buildResult, String duration) {
        this.buildNumber = buildNumber;
        this.buildResult = buildResult;
        this.duration = duration;
    }

    public Integer getBuildNumber() {
        return buildNumber;
    }

    public String getBuildResult() {
        return buildResult;
    }

    public BuildStatus getBuildStatus() {
        return BuildStatus.fromStatus(buildResult);
    }

    public String getDuration() {
        return duration;
    }
}
