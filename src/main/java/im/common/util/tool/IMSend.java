package im.common.util.tool;

import im.common.IMPacket;
import im.common.protof.ResponseModel;
import org.tio.core.Aio;
import org.tio.core.ChannelContext;

/**
 * Created by 马东 on 2017/9/24.
 */
public class IMSend {
    public static void send(ChannelContext<Object, IMPacket, Object> channelContext, ResponseModel.ImResponse imResponse){
        IMPacket imPacket = new IMPacket();
        imPacket.setBody(imResponse.toByteArray());
        Aio.send(channelContext,imPacket);
    }
}
