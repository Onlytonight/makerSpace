package com.qks.makerSpace.controller;

import com.alibaba.fastjson.JSONObject;
import com.qks.makerSpace.exception.ServiceException;
import com.qks.makerSpace.service.AdminService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * 获取全部科技园企业的部分信息
     */
    @RequestMapping(value = "/technology/all", method = RequestMethod.GET)
    private Map<String, Object> getTechnologyAllDetails() {
        return adminService.getAllDetails();
    }

    /**
     * 获取全部众创空间企业的申请信息
     */
    @RequestMapping(value = "/space/all", method = RequestMethod.GET)
    private Map<String, Object> getSpaceAllDetails() {
        return adminService.getAllSpaceDetails();
    }

    /**
     * 获取某一个企业入园申请
     * @param String
     * @return HashMap
     */
    @RequestMapping(value = "technology/{creditCode}", method = RequestMethod.GET)
    private Map<String, Object> getCompanyById(@PathVariable String creditCode) {
        return adminService.getTechnologyById(creditCode);
    }

    /**
     * 删除某一个企业入园申请
     * @return
     */
    @RequestMapping(value = "technology", method = RequestMethod.DELETE)
    private Map<String, Object> deleteOldByCreditCode(@RequestBody JSONObject map) throws ServiceException {
        String creditCode = map.getString("creditCode");

        return adminService.deleteByCreditCode(creditCode);
    }

    /**
     * 获取某一个企业众创空间申请
     * @param String
     * @return HashMap
     */
    @RequestMapping(value = "space/{inApplyId}", method = RequestMethod.GET)
    private Map<String, Object> getSpaceById(@PathVariable String inApplyId) {
        return adminService.getSpaceById(inApplyId);
    }

    /**
     * 删除某一个企业众创空间申请
     * @return HashMap
     */
    @RequestMapping(value = "space", method = RequestMethod.DELETE)
    private Map<String, Object> deleteSpaceById(@RequestBody JSONObject map) throws ServiceException {
        return adminService.deleteSpaceById(map.getString("inApplyId"));
    }

    /**
     * 同意某一个企业科技园申请
     * @return HashMap
     */
    @RequestMapping(value = "technology/notarize", method = RequestMethod.POST)
    private Map<String, Object> agreeTechnologyById(@RequestBody JSONObject map) {
        return adminService.agreeTechnologyById(map);
    }

    /**
     * 取消某一个企业科技园申请
     * @return HashMap
     */
    @RequestMapping(value = "technology/countermand", method = RequestMethod.POST)
    private Map<String, Object> disagreeTechnologyById(@RequestBody JSONObject map) {
        return adminService.disagreeTechnologyById(map);
    }

    /**
     * 同意某一个企业众创空间申请
     * @return HashMap
     */
    @RequestMapping(value = "space/notarize", method = RequestMethod.POST)
    private Map<String, Object> agreeSpaceById(@RequestBody JSONObject map) {
        return adminService.agreeSpaceById(map);
    }

    /**
     * 取消某一个企业众创空间申请
     * @return HashMap
     */
    @RequestMapping(value = "space/countermand", method = RequestMethod.POST)
    private Map<String, Object> disagreeSpaceById(@RequestBody JSONObject map) {
        return adminService.disagreeSpaceById(map);
    }


    /**
     * 获取导出表的信息
     * @param HttpServletResponse
     */
    @RequestMapping(value = "/form/situation", method = RequestMethod.GET)
    private void getStatisticalForm(HttpServletResponse response) throws Exception {
        adminService.downLoadWord(response, adminService.getDownLoadForm());
    }

}
