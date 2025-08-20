package now;

import now.DatabaseConnection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class InvoiceView extends JFrame {
    public InvoiceView() {
        setTitle("Past Invoices");
        setSize(600, 400);
        setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Invoice ID", "Total", "Date"}, 0);
        JTable table = new JTable(model);
        loadInvoices(model);

        JButton viewBtn = new JButton("View Details");
        viewBtn.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected != -1) {
                int invoiceId = (int) table.getValueAt(selected, 0);
                showItems(invoiceId);
            }
        });

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(viewBtn, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void loadInvoices(DefaultTableModel model) {
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM invoices")) {

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("invoice_id"),
                        rs.getDouble("total_amount"),
                        rs.getTimestamp("created_at")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showItems(int invoiceId) {
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM invoice_items WHERE invoice_id = ?")) {

            ps.setInt(1, invoiceId);
            ResultSet rs = ps.executeQuery();

            StringBuilder sb = new StringBuilder("Items in Invoice #" + invoiceId + ":\n\n");
            while (rs.next()) {
                sb.append(rs.getString("product_name")).append(" - ₹")
                        .append(rs.getDouble("price")).append(" x ")
                        .append(rs.getInt("quantity")).append("\n");
            }

            JOptionPane.showMessageDialog(this, sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
