package com.patikadev.View;

import com.patikadev.Helper.*;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OperatorGUI extends JFrame {

    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_user_list;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;

    private final Operator operator;

    public OperatorGUI(Operator operator){
        this.operator = operator;
        add(wrapper);
        setSize(1000, 500);
        int x = Helper.screenCentered("x", getSize());
        int y = Helper.screenCentered("y", getSize());
        setLocation(x,y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Hoşgeldin : " + operator.getUser_name());

        //ModelUserList
        mdl_user_list = new DefaultTableModel();
        Object[] col_user_list = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
        mdl_user_list.setColumnIdentifiers(col_user_list);

        for (User obj : User.getList()) {
            Object[] row = new Object[col_user_list.length];
            row[0] = obj.getUser_id();
            row[1] = obj.getUser_name();
            row[2] = obj.getUser_uname();
            row[3] = obj.getUser_password();
            row[4] = obj.getUser_type();
            mdl_user_list.addRow(row);
        }

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);
    }

    public static void main(String[] args) {
        Helper.setLayout();
        Operator op = new Operator();
        op.setUser_id(1);
        op.setUser_name("Yücel İKİZ");
        op.setUser_password("1234");
        op.setUser_type("operator");
        op.setUser_uname("yucelikiz");

        DBConnector.getInstance();

        OperatorGUI operatorGUI = new OperatorGUI(op);
    }
}
