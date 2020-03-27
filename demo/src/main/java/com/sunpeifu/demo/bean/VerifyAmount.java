package com.sunpeifu.demo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * 对账结果表
 * </p>
 *
 * @author
 * @since 2020-03-06
 */
@Data
@Accessors(chain = true)
@Builder
@TableName("pay_verify_amount")
@ApiModel(value = "VerifyAmount对象", description = "对账结果表 ")
@NoArgsConstructor
@AllArgsConstructor
public class VerifyAmount implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "医院平台id")
    @TableField("hpid")
    private String hpid;

    @ApiModelProperty(value = "医院id")
    @TableField("hospital_id")
    private String hospitalId;

    @ApiModelProperty(value = "医院名称")
    @TableField("hospital_name")
    private String hospitalName;

    @ApiModelProperty(value = "his系统订单id")
    @TableField("his_order_id")
    private String hisOrderId;

    @ApiModelProperty(value = "his系统订单号")
    @TableField("his_order_no")
    private String hisOrderNo;

    @ApiModelProperty(value = "his系统流水号")
    @TableField("his_serial_no")
    private String hisSerialNo;

    @ApiModelProperty(value = "his系统退款单号")
    @TableField("his_refund_no")
    private String hisRefundNo;

    @ApiModelProperty(value = "商户订单id")
    @TableField("merchant_order_id")
    private String merchantOrderId;

    @ApiModelProperty(value = "商户订单号")
    @TableField("merchant_order_no")
    private String merchantOrderNo;

    @ApiModelProperty(value = "商户退款单号")
    @TableField("merchant_refund_no")
    private String merchantRefundNo;

    @ApiModelProperty(value = "交易金额")
    @TableField("trade_amount")
    private BigDecimal tradeAmount;

    @ApiModelProperty(value = "第三方支付机账单明细表主键id")
    @TableField("agency_bill_id")
    private String agencyBillId;

    @ApiModelProperty(value = "收款平台支付流水号")
    @TableField("third_transaction_id")
    private String thirdTransactionId;

    @ApiModelProperty(value = "收款平台退款流水号")
    @TableField("third_refund_transaction_id")
    private String thirdRefundTransactionId;

    @ApiModelProperty(value = "金额差额")
    @TableField("different_amount")
    private BigDecimal differentAmount;

    @ApiModelProperty(value = "对账状态1对账正常,2待补费,3待退费4已平账,")
    @TableField("verify_status")
    private Integer verifyStatus;

    @ApiModelProperty(value = "账单状态: 1账单正常 2His未收银行已收 3HIS已收银行未收 4HIS未退银行已退, 5HIS已退银行未退,")
    @TableField("amount_status")
    private Integer amountStatus;

    @ApiModelProperty(value = "交易类型1支付2退款")
    @TableField("bus_type")
    private Integer busType;

    @ApiModelProperty(value = "交易渠道")
    @TableField("trade_channel")
    private Integer tradeChannel;

    @ApiModelProperty(value = "1 微信 2 支付宝")
    @TableField("pay_type")
    private Integer payType;

    @ApiModelProperty(value = "交易时间")
    @TableField("trade_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tradeTime;


    @ApiModelProperty(value = "对账时间")
    @TableField("verify_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime verifyTime;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "对账备注")
    @TableField("verify_mark")
    private String verifyMark;

    @ApiModelProperty(value = "对账错误信息")
    @TableField("error_msg")
    private String errorMsg;

    @ApiModelProperty(value = "对账错误类型")
    @TableField("error_type")
    private String errorType;

    @ApiModelProperty(value = "是否删除")
    @TableField("is_deleted")
    private Integer isDeleted;

    /***
     * 根据业务规则,重写hashcode和equals方法
     * 当hisOrderId,agencyBillId,busType一致时认为是同一个对象
     */
    @Override
    public int hashCode() {
        return Objects.hash(hisOrderId, agencyBillId, busType);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerifyAmount that = (VerifyAmount) o;
        return Objects.equals(hisOrderId, that.hisOrderId) &&
                Objects.equals(agencyBillId, that.agencyBillId) &&
                Objects.equals(busType, that.busType);
    }

}
