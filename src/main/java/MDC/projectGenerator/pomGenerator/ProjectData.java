package MDC.projectGenerator.pomGenerator;

public class ProjectData {

    static String groupId;
    static String artifactId;
    static String version;
    static String name;
    static String description;


//    constructor
    public ProjectData(String groupId, String artifactId, String version, String name, String description) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.name = name;
        this.description = description;
    }

//    getter and setter
    public static String getGroupId() {
        return groupId;
    }

    public static void setGroupId(String groupId) {
        ProjectData.groupId = groupId;
    }

    public static String getArtifactId() {
        return artifactId;
    }

    public static void setArtifactId(String artifactId) {
        ProjectData.artifactId = artifactId;
    }

    public static String getVersion() {
        return version;
    }

    public static void setVersion(String version) {
        ProjectData.version = version;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        ProjectData.name = name;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        ProjectData.description = description;
    }



}
