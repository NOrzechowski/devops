package com.neilo.aithre.entity;

import javax.persistence.*;

import javax.persistence.Id;

@Entity
public class Skill {
    @Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer skillId;
    @Column
    private String skillName;
    @ManyToOne
    private Employee employee;

    public Skill(String skillName) {
		this.skillName = skillName;
	}

	public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Employee getemployee() {
        return employee;
    }

    public void setemployee(Employee employee) {
        this.employee = employee;
    }

    public Skill() {
    }

    public Skill(String skillName, Employee employee) {
        this.skillName = skillName;
        this.employee = employee;
    }
}
