package com.qks.makerSpace.controller;

import com.alibaba.fastjson.JSONObject;
import com.qks.makerSpace.exception.ServiceException;
import com.qks.makerSpace.service.NewEnterpriseService;
import com.qks.makerSpace.util.MyResponseUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/api/new")
public class NewEnterpriseController {

    private final NewEnterpriseService newEnterpriseService;

    public NewEnterpriseController(NewEnterpriseService newEnterpriseService) {
        this.newEnterpriseService = newEnterpriseService;
    }

    /**
     * 信息状态展示
     * @param
     * @return
     */
    @RequestMapping(value = "newEnterprise", method = RequestMethod.GET)
    private Map<String, Object> getNewEnterprise() {
        return newEnterpriseService.getNewEnterprise();
    }

    /**
     * 注册
     * @param str
     * @return
     */
    @RequestMapping(value = "newRegister", method = RequestMethod.POST)
    private Map<String, Object> newRegister(@RequestPart("file") MultipartFile[] file,
                                            @RequestPart("map") String str) throws Exception {
        if (file.length == 0) {
            return MyResponseUtil.getResultMap(null,-1,"文件上传失败");
        } else {
            return newEnterpriseService.newRegister(str, file);
        }
    }

    /**
     * 续约
     * @param map
     * @return
     */
    @RequestMapping(value = "demand", method = RequestMethod.PUT)
    private Map<String, Object> oldEnterprisePay(@RequestPart("map") String json,
                                                 @RequestPart("paymentVoucher") MultipartFile voucher) throws ServiceException, IOException {
        if (voucher == null)
            throw new ServiceException("缺少缴费凭证");

        return newEnterpriseService.newEnterpriseContract(json, voucher);
    }

    /**
     * 房间申请
     * @param map
     * @return
     */
    @RequestMapping(value = "demand", method = RequestMethod.POST)
    private Map<String, Object> newEnterpriseDemand(@RequestBody JSONObject map) throws ServiceException {
        return newEnterpriseService.newEnterpriseDemand(map);
    }

    /**
     * 入园申请表填写
     * @param str
     * @return
     */
    @RequestMapping(value = "newEnterprise", method = RequestMethod.PUT)
    private Map<String, Object> updateNewEnterprise(HttpServletRequest httpServletRequest,
                                                    @RequestPart("map") String  str,
                                                    @RequestParam("file") MultipartFile[] file) throws Exception {
        return newEnterpriseService.updateNewEnterprise(httpServletRequest.getHeader("token"), str, file);
    }

    /**
     * 获取某个企业的所有季度报表
     * @param str
     * @return
     */
    @RequestMapping(value = "/form/technology", method = RequestMethod.GET)
    private Map<String, Object> getFormByCreditCode(HttpServletRequest httpServletRequest) throws Exception {
        return newEnterpriseService.getFormByCreditCode(httpServletRequest.getHeader("token"));
    }
}