package MDC.projectGenerator.pomGenerator;

public class Parent {

    static String groupId;
    static String artifactId;
    static String version;
    static String relativePath;

//    getter and setter
    public static String getGroupId() {
        return groupId;
    }

    public static void setGroupId(String groupId) {
        Parent.groupId = groupId;
    }

    public static String getArtifactId() {
        return artifactId;
    }

    public static void setArtifactId(String artifactId) {
        Parent.artifactId = artifactId;
    }

    public static String getVersion() {
        return version;
    }

    public static void setVersion(String version) {
        Parent.version = version;
    }

    public static String getRelativePath() {
        return relativePath;
    }

    public static void setRelativePath(String relativePath) {
        Parent.relativePath = relativePath;
    }


}
