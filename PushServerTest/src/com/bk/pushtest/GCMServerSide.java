package com.bk.pushtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class GCMServerSide {
	public void sendMessage() throws IOException {
		Sender sender = new Sender("AIzaSyBF3pAx3-om0SdU9m2m9l04chJhwBpdnf4");
		String regId = "APA91bEpkmnglquH699SgT6UzHb_ai8e_A5LV10lPApXDC_0fyIRcf-d3ElNTQXYW8bd1QikXa4kJBcVQ84WA7BPVGEvn9gqj0EK_fas0QdfKMDSJF7az8LvZJO4DK4X7xCB_1wW_wS2";

		Message.Builder messageBuilder = new Message.Builder();

		//Vibrate
//		messageBuilder.addData("ActionName", "VIBRATE");
		//Locate
//		messageBuilder.addData("ActionName", "LOCATE");
		
		//Message
		messageBuilder.addData("ActionName", "MESSAGE");
		messageBuilder.addData("Message", "World");
		Message message = messageBuilder.build();

		List<String> list = new ArrayList<String>();
		list.add(regId);
		MulticastResult multiResult = sender.send(message, list, 5);
		if (multiResult != null) {
			List<Result> resultList = multiResult.getResults();
			for (Result result : resultList) {
				System.out.println(result.getMessageId());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		GCMServerSide s = new GCMServerSide();
		s.sendMessage();
	}

}
