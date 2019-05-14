package com.xavier.center.api;

import com.xavier.center.service.SequenceService;
import com.xavier.center.util.ExprUtil;
import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(value = "统一Id生成中心接口")
@RestController
@RequestMapping("/")
public class SequenceController {

    public static final int DEFAULT_INCREMENT = 1;

    @Autowired
    private SequenceService sequenceService;

    @ApiOperation(value = "根据传入key与expr的表达式生成id序列", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "生成id的key", paramType = "query", dataType = "String", example = "key_test")
            , @ApiImplicitParam(name = "expr", value = "expr表达式", paramType = "query", dataType = "String", example = "'LF'+yyyyMMdd()+format(seq,6)"),
    })
    @PostMapping("/gen")
    public String seq(
            @RequestParam(name = "key") String key
            , @RequestParam(name = "expr") String expr) {
        Map row = new HashMap();
        row.put("seq", sequenceService.generate(key, DEFAULT_INCREMENT));
        return (String) ExprUtil.parseExpr(expr, row);
    }
}
