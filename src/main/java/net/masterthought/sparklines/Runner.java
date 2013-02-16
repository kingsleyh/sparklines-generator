//package net.masterthought.sparklines;
//
//import java.io.File;
//import java.util.ArrayList;
//
//public class Runner {
//
//    public static void main(String[] args) throws Exception {
//        File rd = new File("/Users/kings/.jenkins/jobs/cucumber-jvm/builds/82/jenkins-sparklines");
//        ArrayList<BuildInformation> jobHistory = new ArrayList<BuildInformation>();
//        jobHistory.add(new BuildInformation(1,"SUCCESS","1"));
//        jobHistory.add(new BuildInformation(2,"ABORTED","1"));
//        jobHistory.add(new BuildInformation(3,"SUCCESS","1"));
//        jobHistory.add(new BuildInformation(4,"FAILURE","1"));
//        jobHistory.add(new BuildInformation(5,"SUCCESS","1"));
//        jobHistory.add(new BuildInformation(6,"SUCCESS","1"));
//
//        SparklinesGenerator sparklinesGenerator = new SparklinesGenerator("FAILURE", "", "/url",rd, "cucumber-jvm", jobHistory);
//        sparklinesGenerator.generateBuildStatusBasic();
//        sparklinesGenerator.generateBuildStatusJobName();
//        sparklinesGenerator.generateJobStatusHistory();
//        sparklinesGenerator.generateJobStatusHistoryPie();
//        sparklinesGenerator.generateOverview();
//    }
//
//
//}
