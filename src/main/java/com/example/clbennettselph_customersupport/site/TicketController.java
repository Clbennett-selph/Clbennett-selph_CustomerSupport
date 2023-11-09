package com.example.clbennettselph_customersupport.site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("ticket")
public class TicketController {
    private volatile int TICKET_ID = 1;
    private Map<Integer, Ticket> ticketDB = new LinkedHashMap<>();


    @RequestMapping(value={"list", ""})
    public String listTickets(Model model) {
        model.addAttribute("ticketDatabase", ticketDB);
        return "listTickets";
    }

    @GetMapping("create")
    public ModelAndView createTicket() {
        return new ModelAndView("ticketForm", "ticket", new TicketForm());
    }

    @PostMapping("create")
    public View createPost (@ModelAttribute("ticket")TicketForm form) throws IOException {
        Ticket tick = new Ticket();
        tick.setCustomerName(form.getCustomerName());
        tick.setSubject(form.getSubject());
        tick.setTicketBody(form.getTicketBody());

        MultipartFile file = form.getAttachment();
        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setContents(file.getBytes());
        if((attachment.getName() != null && attachment.getName().length() > 0) ||
                (attachment.getContents() != null && attachment.getContents().length > 0)) {
                tick.setAttachments(attachment);
        }

        int id;
        synchronized (this) {
            id= this.TICKET_ID++;
            ticketDB.put(id, tick);
        }

        return new RedirectView("view/"+id, true, false);
    }

    @GetMapping("view/{ticketId}")
    public ModelAndView viewPost(Model model, @PathVariable("ticketId")int ticketId) {
        Ticket tick = ticketDB.get(ticketId);
        if (tick == null) {
            return new ModelAndView(new RedirectView("ticket/list", true, false));
        }

        model.addAttribute("ticketId", ticketId);
        model.addAttribute("ticket", tick);

        return new ModelAndView("viewTicket");
    }

    @GetMapping("/{ticketId}/attachment/{attachment:.+}")
    public View downloadAttachment (@PathVariable("ticketId")int ticketId, @PathVariable("attachment")String name) {
        Ticket tick = ticketDB.get(ticketId);
        if(tick == null) {
            return new RedirectView("listTickets", true, false);
        }

        Attachment attachment = tick.getAttachments();
        if (attachment == null) {
            return new RedirectView("listTickets", true, false);
        }
        return new DownloadView(attachment.getName(), attachment.getContents());
    }

    public static class TicketForm {
        private String customerName;
        private String subject;
        private String ticketBody;
        private MultipartFile attachment;

        public String getCustomerName() {
            return customerName;
        }
        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getSubject() {
            return subject;
        }
        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTicketBody() {
            return ticketBody;
        }
        public void setTicketBody(String ticketBody) {
            this.ticketBody = ticketBody;
        }

        public MultipartFile getAttachment() {
            return attachment;
        }
        public void setAttachment(MultipartFile attachment) {
            this.attachment = attachment;
        }
    }

}
