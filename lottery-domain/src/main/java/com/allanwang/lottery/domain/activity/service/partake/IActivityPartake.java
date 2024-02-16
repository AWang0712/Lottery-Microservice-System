package com.allanwang.lottery.domain.activity.service.partake;

import com.allanwang.lottery.common.Result;
import com.allanwang.lottery.domain.activity.model.req.PartakeReq;
import com.allanwang.lottery.domain.activity.model.res.PartakeResult;
import com.allanwang.lottery.domain.activity.model.vo.DrawOrderVO;
import com.allanwang.lottery.domain.activity.model.vo.InvoiceVO;

import java.util.List;



public interface IActivityPartake {
    /**
     * partake activity
     * @param req
     * @return
     */
    PartakeResult doPartake(PartakeReq req);

    /**
     * save draw order
     * @param drawOrder
     * @return
     */
    Result recordDrawOrder(DrawOrderVO drawOrder);

    /**
     * update invoice mq state
     *  @param uId
     * @param orderId
     * @param mqState
     */
    void updateInvoiceMqState(String uId, Long orderId, Integer mqState);

    /**
     * Scanning the MQ status of shipment orders, scanning out orders that have not been sent MQs for compensation
     *
     * @param dbCount
     * @param tbCount
     * @return List<InvoiceVO>
     */
    List<InvoiceVO> scanInvoiceMqState(int dbCount, int tbCount);


}
