package MDC.projectGenerator.pomGenerator;

public class Dependency {

    String groupId;
    String artifactId;
    String scope;

//    constructor
    public Dependency(String groupId, String artifactId, String scope) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.scope = scope;
    }

    public Dependency(String groupId, String artifactId) {
        this.groupId = groupId;
        this.artifactId = artifactId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
