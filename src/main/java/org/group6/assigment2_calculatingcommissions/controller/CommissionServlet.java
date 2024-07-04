package org.group6.assigment2_calculatingcommissions.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.group6.assigment2_calculatingcommissions.model.CommissionInput;
import org.group6.assigment2_calculatingcommissions.service.CommissionService;

import java.io.IOException;

@WebServlet(name = "CommissionServlet", urlPatterns = "/commission")
public class CommissionServlet extends HttpServlet {
    private final CommissionService commissionService = new CommissionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/commissionForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommissionInput input = new CommissionInput();
        input.setSalaried(req.getParameter("isSalaried") != null);
        input.setItemPrice(Double.parseDouble(req.getParameter("itemPrice")));
        input.setItemType(req.getParameter("itemType"));
        input.setCustomerType(req.getParameter("customerType"));

        double commission = commissionService.calculateCommission(input);

        req.setAttribute("commission", commission);
        req.getRequestDispatcher("/WEB-INF/view/commissionForm.jsp").forward(req, resp);
    }
}