package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String buildingImplements;
    private String helmet;

    public Builder() {
    }

    public Builder(byte experience, String project,
                   String customer, String technicalAssignment,
                   String contractorToOutsource, String buildingImplements,
                   String helmet) {
        super(experience, project, customer, technicalAssignment, contractorToOutsource);
        this.buildingImplements = buildingImplements;
        this.helmet = helmet;
    }

    public Builder(String name, String surname,
                   String education, int birthday,
                   int salary, byte specialization) {
        super(name, surname, education, birthday, salary, specialization);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public String getBuildingImplements() {
        return buildingImplements;
    }

    public void setBuildingImplements(String buildingImplements) {
        this.buildingImplements = buildingImplements;
    }

    public String getHelmet() {
        return helmet;
    }

    public void setHelmet(String helmet) {
        this.helmet = helmet;
    }
}
