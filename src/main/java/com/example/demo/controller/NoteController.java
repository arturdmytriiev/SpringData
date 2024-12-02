package com.example.demo.controller;

import com.example.demo.model.Note;
import com.example.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/note")
public class NoteController {
    @Autowired
    NoteService noteService;

    @GetMapping(value = "/list")
    public ModelAndView listAll()
    {
        ModelAndView model = new ModelAndView("list");
        model.addObject("listAll",noteService.listAll());
        return model;
    }
    @PostMapping(value = "/delete")
    public ModelAndView delete(@RequestParam ("id") Long id, RedirectAttributes redirectAttributes )
    {
        noteService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Note deleted successfully");
        return new ModelAndView("redirect:/note/list");
    }
    @GetMapping(value = "/edit")
    public ModelAndView edit(@RequestParam("id")Long id)
    {
        Note note = noteService.getById(id);
        ModelAndView model = new ModelAndView("edit");
        model.addObject("note", note);
        return model;
    }

    @PostMapping(value = "/edit")
    public ModelAndView edit(Note note, RedirectAttributes redirectAttributes)
    {
        noteService.update(note);
        redirectAttributes.addFlashAttribute("message", "Note edited successfully");
        return new ModelAndView("redirect:/note/list");
    }

}
