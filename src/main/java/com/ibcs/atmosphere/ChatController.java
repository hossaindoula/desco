package com.ibcs.atmosphere;

import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author hossaindoula<hossaindoula@gmail.com> 5/21/2016.
 */

@Controller
@RequestMapping("/chat")
public class ChatController {

    ArrayList<HttpSession> subscribers = new ArrayList<HttpSession>();

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView getView() {
        return new ModelAndView("chat");
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    @ResponseBody public void onRequest(AtmosphereResource atmosphereResource, HttpSession session) throws IOException {

        AtmosphereRequest atmosphereRequest = atmosphereResource.getRequest();

        System.out.println(atmosphereRequest.getHeader("negotiating"));
        if(atmosphereRequest.getHeader("negotiating") == null) {
            atmosphereResource.resumeOnBroadcast(atmosphereResource.transport() == AtmosphereResource.TRANSPORT.LONG_POLLING).suspend();
        } else {
            atmosphereResource.getResponse().getWriter().write("OK");
        }

        subscribers.add(session);

        System.out.println("Subscribers: " + subscribers.size());

        for(HttpSession httpSession : subscribers) {
            System.out.println(httpSession);
        }

    }

    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    @ResponseBody public void onPost(AtmosphereResource atmosphereResource) throws IOException{
        AtmosphereRequest atmosphereRequest = atmosphereResource.getRequest();

        String body = atmosphereRequest.getReader().readLine().trim();

        String author = body.substring(body.indexOf(":") + 2, body.indexOf(",") - 1);
        String message = body.substring(body.lastIndexOf(":") + 2, body.length() - 2);

        atmosphereResource.getBroadcaster().broadcast(new Data(author, message).toString());

    }

    private final static class Data {

        private final String text;
        private final String author;

        public Data(String author, String text) {
            this.author = author;
            this.text = text;
        }

        public String toString() {
            return "{ \"text\" : \"" + text + "\", \"author\" : \"" + author + "\" , \"time\" : " + new Date().getTime() + "}";
        }

    }

}
