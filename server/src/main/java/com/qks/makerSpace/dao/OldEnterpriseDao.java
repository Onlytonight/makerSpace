package com.qks.makerSpace.dao;

import com.qks.makerSpace.entity.database.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OldEnterpriseDao {

    @Insert("insert into old(old_id, credit_code, organization_code, name, password, " +
            "represent, represent_phone, register_address, represent_email, agent, agent_phone, agent_email)" +
            "VALUES (#{oldId}, #{creditCode}, #{organizationCode}, #{name}, #{password}, #{represent}, " +
            "#{representPhone}, #{registerAddress}, #{representEmail}, #{agent}, #{agentPhone}, #{agentEmail})")
    Integer oldRegister(Old old);

    @Select("")
    List<Old> getAllOld();

    @Update("update old " +
            "set register_address = #{registerAddress}, license = #{license}, register_capital = #{registerCapital}," +
            "  real_address = #{realAddress}, real_capital = #{realCapital}, last_income = #{lastIncome}," +
            "  last_tax = #{lastTax}, employees = #{employees}, origin_number = #{originNumber}," +
            "  set_date = #{setDate}, nature = #{nature}, certificate = #{certificate}, involved = #{involved}," +
            "  main_business = #{mainBusiness}, way = #{way}, business = #{business}, " +
            "  old_shareholder_id = #{oldShareholderId}, old_mainperson_id = #{oldMainpersonId}, " +
            "  old_project_id = #{oldProjectId}, old_intellectual_id = #{oldIntellectualId}," +
            "  old_funding_id = #{oldFundingId}, cooperation = #{cooperation}, suggestion = #{suggestion}, note = #{note} " +
            "where old_id = #{oldId}")
    Integer updateOld(Old old);

    @Update("update old set state = #{state}, submit_time = #{submitTime}, " +
            "room = #{room}, inapply_id = #{inapply_id} " +
            "where old_id = #{oldId}")
    Integer updateOldForDemand(String oldId, String state, String submitTime, String room, String inapplyId);

    /**
     * 以下是关于插入Old相关子表的操作
     */
    @Insert("insert into old_mainperson (id, name, born, job, school, title, background, professional, old_mainperson_id)" +
            "values (#{id}, #{oldMainpersonId}, #{name}, #{born}, #{job}, #{school}, #{title}, #{background}, #{professional})")
    Integer insertOldMainPeople(OldMainPerson oldMainPerson);

    @Insert("insert into old_project (id, project_brief, advantage, market, energy, pollution, noise, others, old_project_id) " +
            "values (#{id}, #{project_brief}, #{advantage}, #{market}, #{energy}, #{pollution}, #{noise}, #{others}, #{oldProjectId});")
    Integer insertOldProjects(OldProject oldProject);

    @Insert("insert into old_intellectual (id, name, kind, apply_time, approval_time, intellectual_file, old_intellectual_id) " +
            "values (#{id}, #{name}, #{kind}, #{applyTime}, #{approvalTime}, #{intellectualFile}, #{oldIntellectualId});")
    Integer insertOldIntellects(OldIntellectual oldIntellectual);

    @Insert("insert into old_funding(id, name, level, time, grants, award, funding_id) " +
            "VALUES (#{id}, #{name}, #{level}, #{time}, #{grants}, #{award}, #{fundingId})")
    Integer insertOldFundings(OldFunding oldFunding);

    @Insert("insert into old_shareholder(id, name, stake, nature, old_shareholder_id) " +
            "VALUES (#{id}, #{name}, #{stake}, #{nature}, #{oldShareholderId})")
    Integer insertOldShareholder(OldShareholder oldShareholder);

    @Insert("insert into old_demand(id, lease_area, position, lease, floor, electric, water, web, others, old_demand_id) " +
            "VALUES (#{id}, #{leaseArea}, #{position}, #{lease}, #{floor}, #{electric}, #{water}, #{web}, #{others}, #{oldDemandId}) ")
    Integer addOldDemand(OldDemand oldDemand);

    /**
     * 以下是关于查询Old相关子表的操作
     */
    @Select("select * from old_demand where old_demand_id = #{id}")
    List<OldDemand> getOldDemandById(String id);

    @Select("select * from old_mainperson where old_mainperson_id = #{id}")
    List<OldMainPerson>  getOldMainPeopleById(String id);

    @Select("select * from old_project where old_project_id = #{id}")
    List<OldProject> getOldProjectById(String id);

    @Select("select * from old_funding where old_funding.= #{id}")
    List<OldFunding> getOldFundingById(String id);

    @Select("select * from old_shareholder where old_shareholder_id = #{id}")
    List<OldShareholder> getOldShareholderById(String id);

    @Select("select * from old_intellectual where old_intellectual_id = #{id}")
    List<OldIntellectual> getOldIntellectualById(String id);

    @Update("update user_company set credit_code = #{id} where user_id = #{userId}")
    Integer updateUserCompany(String userId, String id);

    @Insert("insert into audit(audit_id, administrator_audit, leadership_audit) " +
            "values (#{id}, #{administratorAudit}, #{leadershipAudit})")
    Integer insertAudit(Audit audit);
}
