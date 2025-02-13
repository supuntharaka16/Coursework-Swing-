import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.time.*;
import javax.swing.table.*;


class Contact{
	private String ID;
	private String Name;
	private String phoneNumber;
	private String companyName;
	private double salary;
	private String bday;
	
	
	
	public Contact(String ID, String Name, String phoneNumber, String companyName, double salary, String bday){
		this.ID = ID;
		this.Name = Name;
		this.phoneNumber = phoneNumber;
		this.companyName = companyName;
		this.salary = salary;
		this.bday = bday;
		
		}
		public  void setID(String ID){
			this.ID = ID;
		}
		public  void setName(String Name){
			this.Name = Name;
		}
		public  void setPhoneNumber(String phoneNumber){
			this.phoneNumber = phoneNumber;
		}
		public  void setCompanyName(String companyName){
			this.companyName = companyName;
		}
			
		public  void setSalary(double salary){
			this.salary = salary;
		}
		public  void setBday(String bday){
			this.bday = bday;
		}
		
		public String getID(){
			return ID;
		}
		
		public String getName(){
			return Name;
		}
		
		public String getPhoneNumber(){
			return phoneNumber;
		}
		
		public String getCompanyName(){
			return companyName;
		}
		
		public double getSalary(){
			return salary;
		}
		
		public String getBday(){
			return bday;
		}
				
		
	}
	//---------------------------------------------Add Student Form-------------------------------------------------------
	class AddContactForm extends JFrame{
		
		
		
	  
	   
		private JLabel lblID;
		private JLabel lblName;
		private JLabel lblPhoneNumber;
		private JLabel lblCompany;
		private JLabel lblSalary;
		private JLabel lblBday;
		
		private JButton btnAdd;
		private JButton btnCancel;
		private JButton btnBack;
		
		private JTextField txtId;	
		private JTextField txtName;	
		private JTextField txtPhoneNumber;	
		private JTextField txtCompany;	
		private JTextField txtSalary;	
		private JTextField txtBday;	
		
		 AddContactForm(){
		
		setTitle("Add Contact");
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		setLayout(new BorderLayout());
		
		JPanel tittlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tittleLabel = new JLabel(" ADD CONTACTS");
		tittleLabel.setFont(new Font("",1,28));
		tittleLabel.setHorizontalAlignment(JLabel.CENTER);
		tittlePanel.add(tittleLabel);
		tittlePanel.setBackground(new Color(173, 216, 230));
		add("North", tittlePanel);
		
		JPanel buttonPanel = new JPanel(new GridLayout(2,1));
		JPanel exbttnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			btnAdd=new JButton("Add Contacts");
	btnAdd.setFont(new Font("",1,16));	
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			String id = txtId.getText();
				String name = txtName.getText();
				String phoneNumber = txtPhoneNumber.getText();
				String company = txtCompany.getText();
				double Salary = Double.parseDouble(txtSalary.getText());
				String bday = txtBday.getText();
				
				Contact contact = new Contact(id,name,phoneNumber,company,Salary,bday);
				
				
				
				Contact[] tempContact = new Contact[Ifriendcontact.contactArray.length+1]; 
				for(int i = 0;i<Ifriendcontact.contactArray.length;i++){
					tempContact[i] = Ifriendcontact.contactArray[i];
				}
				Ifriendcontact.contactArray = tempContact;
				Ifriendcontact.contactArray[IFCONTACT1.contactArray.length-1] = contact;
				JOptionPane.showMessageDialog(null,"Added Success");
				generateId();
				txtName.setText("");
				txtPhoneNumber.setText("");
				txtCompany.setText("");
				txtSalary.setText("");
				txtBday.setText("");
			}
		});		
		exbttnPanel.add(btnAdd);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,16));	
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtName.setText("");
				txtPhoneNumber.setText("");
				txtCompany.setText("");
				txtSalary.setText("");
				txtBday.setText("");
			}
		});		
		exbttnPanel.add(btnCancel);
		buttonPanel.add(exbttnPanel);
        
        JPanel backBtnPanle = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnBack = new JButton("Back To HomePage");
		btnBack.setFont(new Font("",1,16));	
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});		
	    backBtnPanle.add(btnBack);
		buttonPanel.add(backBtnPanle);
		
		add("South",buttonPanel);
		
	    JPanel lblPanel = new JPanel(new GridLayout(6,1));
	    
	    lblID = new JLabel("Contact ID");
	    lblID.setFont(new Font("",1,20));
	    lblPanel.add(lblID);
	    
	    lblName = new JLabel("Name");
	    lblName.setFont(new Font("",1,18));
	    lblPanel.add(lblName);
	    
	    lblPhoneNumber = new JLabel("Contact Number");
	    lblPhoneNumber.setFont(new Font("",1,18));
	    lblPanel.add(lblPhoneNumber);
	    
	    lblCompany = new JLabel("Company");
	    lblCompany.setFont(new Font("",1,18));
	    lblPanel.add(lblCompany);
	    
	    lblSalary = new JLabel("Salary");
	    lblSalary.setFont(new Font("",1,18));
	    lblPanel.add(lblSalary);
	    
	    lblBday = new JLabel("Birthday");
	    lblBday.setFont(new Font("",1,18));
	    lblPanel.add(lblBday);
	    
	    add("West",lblPanel);
	    
	    JPanel textPanel=new JPanel(new GridLayout(6,1));
		txtId=new JTextField(6);
		txtId.setEditable(false);
	    generateId();
		txtId.setFont(new Font("",1,18));	
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		idTextPanel.add(txtId);
		
		textPanel.add(idTextPanel);
		
	
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,18));
		txtName.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent evt){
				if(txtName.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"empty student name");
					txtName.requestFocus();
				}
			}
			public void focusGained(FocusEvent arg0) {
				txtName.selectAll();
			}
		});	
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameTextPanel.add(txtName);
		
		textPanel.add(nameTextPanel);
		
		
		
		txtPhoneNumber=new JTextField(15);
		txtPhoneNumber.setFont(new Font("",1,18));
		txtPhoneNumber.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent evt){
				if(txtPhoneNumber.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"empty Phone Number");
					txtPhoneNumber.requestFocus();
				}
				 if(!isPhoneNumberCorrect(txtPhoneNumber.getText())){
					JOptionPane.showMessageDialog(null,"Invalid Phone Number");
					txtPhoneNumber.requestFocus();
			}
			
			if(PhoneNumberExist(txtPhoneNumber.getText())){
				JOptionPane.showMessageDialog(null,"Phone Number is Already exist");
					txtPhoneNumber.requestFocus();
				}
			  
			}
		
			 
				public void focusGained(FocusEvent arg0) {
				txtPhoneNumber.selectAll();
			}
		});		
		JPanel phoneNumberTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		phoneNumberTextPanel.add(txtPhoneNumber);
		
		textPanel.add(phoneNumberTextPanel);
		
		
		txtCompany=new JTextField(15);
		txtCompany.setFont(new Font("",1,18));	
		JPanel companyTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		companyTextPanel.add(txtCompany);
		
		textPanel.add(companyTextPanel);
		
		
		txtSalary=new JTextField(10);
		txtSalary.setFont(new Font("",1,18));	
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		salaryTextPanel.add(txtSalary);
		
		textPanel.add(salaryTextPanel);
		
		
		txtBday=new JTextField(15);
		txtBday.setFont(new Font("",1,18));
		txtBday.addFocusListener(new FocusListener(){	
		public void focusLost(FocusEvent evt){
				if(txtBday.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"empty Phone Number");
					txtBday.requestFocus();
				}
				 if(!validBirthday(txtPhoneNumber.getText())){
					JOptionPane.showMessageDialog(null,"Invalid Phone Number");
					txtBday.requestFocus();
			}
			
			
			  
			}
		
			 
				public void focusGained(FocusEvent arg0) {
				txtBday.selectAll();
			}
		});		
		JPanel bdayTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		bdayTextPanel.add(txtBday);
		
		textPanel.add(bdayTextPanel);
		
		add("Center",textPanel);
		
		
		
			
			}
			
		public  void generateId(){
			if(Ifriendcontact.contactArray.length<=0){
				txtId.setText("B0001");
			}
			else{
				String lastId = Ifriendcontact.contactArray[Ifriendcontact.contactArray.length-1].getID();
				int lastIdNumber=Integer.parseInt(lastId.substring(1));
				String newID = String.format("B%04d",(lastIdNumber+1));
			    txtId.setText(newID);
			}
				
		}
	//-----------------  Check the phone number validation ------------------
	public  boolean isPhoneNumberCorrect(String phoneNumber){
		if(phoneNumber.charAt(0)=='0' && phoneNumber.length() == 10){
				for(int i =0;i<phoneNumber.length();i++){
				if(!Character.isDigit(phoneNumber.charAt(i))){
					return false;
				}			
			}
			return true;
		}
		else{
		return false;
	}
	}
		
		public boolean PhoneNumberExist(String phoneNumber){
			for(int i = 0 ; i<phoneNumber.length();i++){
				if(phoneNumber.equals(Ifriendcontact.contactArray[i].getPhoneNumber())){
					return true;
				}
				
				return false;
			}
			if(phoneNumber.length()==0){
			
				return false;
			}
			return false;
		}
		
		public boolean validBirthday(String bday){
			String[] str = bday.split("[- /]");
		
		int year = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int days = Integer.parseInt(str[2]);
		
		LocalDate currentDate =  LocalDate.now();
		int currentyear = currentDate.getYear();
		int currentmonth = currentDate.getMonthValue();
		int currentdate = currentDate.getDayOfMonth();
		
		if(year>currentyear){
			return false;
		}
		else if(month<=0||month>12){
			return false;
		}
		else if((year%4)!=0 && month==2 && days>28){
			return false;
		}
		else if((year%4)==0 && month==2 && days<=29){
			return true;
		}
		else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
		if(days>0&&days<=31){
			return true;
		}
	}
		else if(month==4||month==6||month==9||month==11){
			if( days>0&&days<=30){
			return true;
		}
	}
		else if(month==currentmonth){
			if(days == currentdate){
			return false;
		}
	}
		return false;
	}
			
		
		
		}
	//-----------------------------------------------------------------------------Search Contact Form------------------------------------------------------------
	
	class SearchContactForm extends JFrame{
		
		private JLabel titleLabel;
		private JLabel lblID;
		private JLabel lblName;
		private JLabel lblPhoneNumber;
		private JLabel lblCompany;
		private JLabel lblSalary;
		private JLabel lblBday;
		
		private JButton btnSearch;
		private JButton btnBack;
		
		private JTextField txtId;	
		private JTextField txtName;	
		private JTextField txtPhoneNumber;	
		private JTextField txtCompany;	
		private JTextField txtSalary;	
		private JTextField txtBday;
		private JTextField txtSearch;
		
		SearchContactForm(){
				
		setTitle("Search Contact");
		setSize(800,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);		
		setLayout(new BorderLayout());
		
		JPanel tittlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tittleLabel = new JLabel(" Search Contacts");
		tittleLabel.setFont(new Font("",1,28));
		tittleLabel.setHorizontalAlignment(JLabel.CENTER);
		tittlePanel.add(tittleLabel);
		tittlePanel.setBackground(new Color(173, 216, 230));
		add("North", tittlePanel);
		
	
		JPanel lblPanel = new JPanel(new GridLayout(7,1));
		txtSearch = new JTextField(15);
	    txtSearch.setFont(new Font("",1,18));	
		JPanel searchTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		searchTextPanel.add(txtSearch);
		lblPanel.add(searchTextPanel);
		
		lblID = new JLabel("Contact ID");
	    lblID.setFont(new Font("",1,20));
	    lblPanel.add(lblID);
	    
	    lblName = new JLabel("Name");
	    lblName.setFont(new Font("",1,18));
	    lblPanel.add(lblName);
	    
	    lblPhoneNumber = new JLabel("Contact Number");
	    lblPhoneNumber.setFont(new Font("",1,18));
	    lblPanel.add(lblPhoneNumber);
	    
	    lblCompany = new JLabel("Company");
	    lblCompany.setFont(new Font("",1,18));
	    lblPanel.add(lblCompany);
	    
	    lblSalary = new JLabel("Salary");
	    lblSalary.setFont(new Font("",1,18));
	    lblPanel.add(lblSalary);
	    
	    lblBday = new JLabel("Birthday");
	    lblBday.setFont(new Font("",1,18));
	    lblPanel.add(lblBday);
	    
	    add("West",lblPanel);
	    
	    JPanel textPanel = new JPanel(new GridLayout(7,1));
	    JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("",1,18));	
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String txt=txtSearch.getText();
				int index=searchContact(txt);
				
				if(index!=-1){
					Contact c1=Ifriendcontact.contactArray[index];
					txtId.setText(c1.getID());
					txtName.setText(c1.getName());
					txtPhoneNumber.setText(c1.getPhoneNumber());
					txtCompany.setText(c1.getCompanyName());
					txtSalary.setText(c1.getSalary()+"");
					txtBday.setText(c1.getBday());
				}else{
					JOptionPane.showMessageDialog(null,"Contact is not exists...");	
				}
			}
		});
		
		searchPanel.add(btnSearch);
	    textPanel.add(searchPanel);
		
		txtId=new JTextField(15);
		txtId.setFont(new Font("",1,18));	
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		idTextPanel.add(txtId);
		
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,18));	
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameTextPanel.add(txtName);
		
		textPanel.add(nameTextPanel);
		
		txtPhoneNumber=new JTextField(15);
		txtPhoneNumber.setFont(new Font("",1,18));	
		JPanel phoneNumberTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		phoneNumberTextPanel.add(txtPhoneNumber);
		
		textPanel.add(phoneNumberTextPanel);
		
		txtCompany=new JTextField(10);
		txtCompany.setFont(new Font("",1,18));	
		JPanel companyNameTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		companyNameTextPanel.add(txtCompany);
		
		textPanel.add(companyNameTextPanel);
		
		txtSalary=new JTextField(10);
		txtSalary.setFont(new Font("",1,18));	
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		salaryTextPanel.add(txtSalary);
		
		textPanel.add(salaryTextPanel);
		
		txtBday=new JTextField(10);
		txtBday.setFont(new Font("",1,18));	
		JPanel bdayTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		bdayTextPanel.add(txtBday);
		
		textPanel.add(bdayTextPanel);
		
		add("Center",textPanel);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnBack = new JButton("Back To HomePage");
		btnBack.setFont(new Font("",1,16));	
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});		
	   
		buttonPanel.add(btnBack);
		
		
	
		
		add("South",buttonPanel);
		
		
		}
		
		
		
		private int searchContact(String txt){
			for(int i = 0 ; i<txt.length();i++){
				if(txt.equalsIgnoreCase(Ifriendcontact.contactArray[i].getPhoneNumber())){
					return i;
				}
				else if(txt.equalsIgnoreCase(Ifriendcontact.contactArray[i].getName())){
					return i;
				}
				
			}
			return -1;
		}
	    
	  
	    
		
		
		
	}
	//---------------------------------------------------------Update Contact Form------------------------------------------------------------
	
	class Update extends JFrame{
		private JLabel titleLabel;
		private JLabel lblID;
		private JLabel lblName;
		private JLabel lblPhoneNumber;
		private JLabel lblCompany;
		private JLabel lblSalary;
		private JLabel lblBday;
		
		private JButton btnSearch;
		private JButton btnBack;
		private JButton btnUpdate;
		private JButton btnCancel;
		
		private JTextField txtId;	
		private JTextField txtName;	
		private JTextField txtPhoneNumber;	
		private JTextField txtCompany;	
		private JTextField txtSalary;	
		private JTextField txtBday;
		private JTextField txtSearch;
		
		
		
		Update(){
				
		setTitle("Update Contact");
		setSize(800,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);		
		setLayout(new BorderLayout());
		
		JPanel tittlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tittleLabel = new JLabel(" UPDATE CONTACTS");
		tittleLabel.setFont(new Font("",1,28));
		tittleLabel.setHorizontalAlignment(JLabel.CENTER);
		tittlePanel.add(tittleLabel);
		tittlePanel.setBackground(new Color(173, 216, 230));
		add("North", tittlePanel);
		
	
		JPanel lblPanel = new JPanel(new GridLayout(7,1));
		txtSearch = new JTextField(15);
	    txtSearch.setFont(new Font("",1,18));	
		JPanel searchTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		searchTextPanel.add(txtSearch);
		lblPanel.add(searchTextPanel);
		
		lblID = new JLabel("Contact ID");
	    lblID.setFont(new Font("",1,20));
	    lblPanel.add(lblID);
	    
	    lblName = new JLabel("Name");
	    lblName.setFont(new Font("",1,18));
	    lblPanel.add(lblName);
	    
	    lblPhoneNumber = new JLabel("Contact Number");
	    lblPhoneNumber.setFont(new Font("",1,18));
	    lblPanel.add(lblPhoneNumber);
	    
	    lblCompany = new JLabel("Company");
	    lblCompany.setFont(new Font("",1,18));
	    lblPanel.add(lblCompany);
	    
	    lblSalary = new JLabel("Salary");
	    lblSalary.setFont(new Font("",1,18));
	    lblPanel.add(lblSalary);
	    
	    lblBday = new JLabel("Birthday");
	    lblBday.setFont(new Font("",1,18));
	    lblPanel.add(lblBday);
	    
	    add("West",lblPanel);
	    
	    JPanel textPanel = new JPanel(new GridLayout(7,1));
	    JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("",1,18));	
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String txt=txtSearch.getText();
				int index=searchContact(txt);
				
				if(index!=-1){
					Contact c1=Ifriendcontact.contactArray[index];
					txtId.setText(c1.getID());
					txtName.setText(c1.getName());
					txtPhoneNumber.setText(c1.getPhoneNumber());
					txtCompany.setText(c1.getCompanyName());
					txtSalary.setText(c1.getSalary()+"");
					txtBday.setText(c1.getBday());
				}else{
					JOptionPane.showMessageDialog(null,"Contact is not exists...");	
				}
			}
		});
		
		searchPanel.add(btnSearch);
	    textPanel.add(searchPanel);
		
		txtId=new JTextField(15);
		txtId.setFont(new Font("",1,18));
		txtId.setEditable(false);	
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		idTextPanel.add(txtId);
		
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,18));	
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameTextPanel.add(txtName);
		
		textPanel.add(nameTextPanel);
		
		txtPhoneNumber=new JTextField(15);
		txtPhoneNumber.setFont(new Font("",1,18));	
		JPanel phoneNumberTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		phoneNumberTextPanel.add(txtPhoneNumber);
		
		textPanel.add(phoneNumberTextPanel);
		
		txtCompany=new JTextField(10);
		txtCompany.setFont(new Font("",1,18));	
		JPanel companyNameTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		companyNameTextPanel.add(txtCompany);
		
		textPanel.add(companyNameTextPanel);
		
		txtSalary=new JTextField(10);
		txtSalary.setFont(new Font("",1,18));	
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		salaryTextPanel.add(txtSalary);
		
		textPanel.add(salaryTextPanel);
		
		txtBday=new JTextField(10);
		txtBday.setFont(new Font("",1,18));	
		JPanel bdayTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		bdayTextPanel.add(txtBday);
		
		textPanel.add(bdayTextPanel);
		
		add("Center",textPanel);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("",1,16));
		btnUpdate.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			    int index =  searchContact(txtId.getText());
			    String id = txtId.getText();
			    if(index!=-1){
			    String name = txtName.getText();
			    String phoneNumber = txtPhoneNumber.getText();
			    String companyName = txtCompany.getText();
			    double salary = Double.parseDouble(txtSalary.getText());
			    String bday = txtBday.getText();
				CONTACT1 c = new CONTACT1 (id,name,phoneNumber,companyName,salary,bday);
				IFCONTACT1.contactArray[index] = c;
				JOptionPane.showMessageDialog(null,"Update Success..");
			}
			else{
				JOptionPane.showMessageDialog(null,id+" is not exists...");	
			}
				
			}
		});		
	   
		buttonPanel.add(btnUpdate);
		
		add("South",buttonPanel);
		
		btnBack = new JButton("Back To HomePage");
		btnBack.setFont(new Font("",1,16));	
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});		
	   
		buttonPanel.add(btnBack);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,16));	
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtName.setText("");
				txtPhoneNumber.setText("");
				txtCompany.setText("");
				txtSalary.setText("");
				txtBday.setText("");
			}
		});		
		buttonPanel.add(btnCancel);
		
		add("South",buttonPanel);
		
		
		}
		
		
		
		private int searchContact(String txt){
			for(int i = 0 ; i<txt.length();i++){
				if(txt.equalsIgnoreCase(Ifriendcontact.contactArray[i].getPhoneNumber())){
					return i;
				}
				else if(txt.equalsIgnoreCase(Ifriendcontact.contactArray[i].getName())){
					return i;
				}
				else if(txt.equalsIgnoreCase(Ifriendcontact.contactArray[i].getID())){
					return i;
				}
				else{
					return -1;
				}
				
			}
			return -1;
		}
		
	}
	//--------------------------------------------------------------Delete Contacts--------------------------------------------------------------------
	
	class DeleteContactsForm extends JFrame{
		
		private JLabel titleLabel;
		private JLabel lblID;
		private JLabel lblName;
		private JLabel lblPhoneNumber;
		private JLabel lblCompany;
		private JLabel lblSalary;
		private JLabel lblBday;
		
		private JButton btnSearch;
		private JButton btnBack;
		private JButton btnDelete;
		private JButton btnCancel;
		
		private JTextField txtId;	
		private JTextField txtName;	
		private JTextField txtPhoneNumber;	
		private JTextField txtCompany;	
		private JTextField txtSalary;	
		private JTextField txtBday;
		private JTextField txtSearch;
		
		DeleteContactsForm(){
				
		setTitle("Delete Contact");
		setSize(800,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);		
		setLayout(new BorderLayout());
		
		JPanel tittlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tittleLabel = new JLabel(" DELETE CONTACTS");
		tittleLabel.setFont(new Font("",1,28));
		tittleLabel.setHorizontalAlignment(JLabel.CENTER);
		tittlePanel.add(tittleLabel);
		tittlePanel.setBackground(new Color(173, 216, 230));
		add("North", tittlePanel);
		
	
		JPanel lblPanel = new JPanel(new GridLayout(7,1));
		txtSearch = new JTextField(15);
	    txtSearch.setFont(new Font("",1,18));	
		JPanel searchTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		searchTextPanel.add(txtSearch);
		lblPanel.add(searchTextPanel);
		
		lblID = new JLabel("Contact ID");
	    lblID.setFont(new Font("",1,20));
	    lblPanel.add(lblID);
	    
	    lblName = new JLabel("Name");
	    lblName.setFont(new Font("",1,18));
	    lblPanel.add(lblName);
	    
	    lblPhoneNumber = new JLabel("Contact Number");
	    lblPhoneNumber.setFont(new Font("",1,18));
	    lblPanel.add(lblPhoneNumber);
	    
	    lblCompany = new JLabel("Company");
	    lblCompany.setFont(new Font("",1,18));
	    lblPanel.add(lblCompany);
	    
	    lblSalary = new JLabel("Salary");
	    lblSalary.setFont(new Font("",1,18));
	    lblPanel.add(lblSalary);
	    
	    lblBday = new JLabel("Birthday");
	    lblBday.setFont(new Font("",1,18));
	    lblPanel.add(lblBday);
	    
	    add("West",lblPanel);
	    
	    JPanel textPanel = new JPanel(new GridLayout(7,1));
	    JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("",1,18));	
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String txt=txtSearch.getText();
				int index=searchContact(txt);
				
				if(index!=-1){
					Contact c1=Ifriendcontact.contactArray[index];
					txtId.setText(c1.getID());
					txtName.setText(c1.getName());
					txtPhoneNumber.setText(c1.getPhoneNumber());
					txtCompany.setText(c1.getCompanyName());
					txtSalary.setText(c1.getSalary()+"");
					txtBday.setText(c1.getBday());
				}else{
					JOptionPane.showMessageDialog(null,"Contact is not exists...");	
				}
			}
		});
		
		searchPanel.add(btnSearch);
	    textPanel.add(searchPanel);
		
		txtId=new JTextField(15);
		txtId.setFont(new Font("",1,18));	
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		idTextPanel.add(txtId);
		
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,18));	
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameTextPanel.add(txtName);
		
		textPanel.add(nameTextPanel);
		
		txtPhoneNumber=new JTextField(15);
		txtPhoneNumber.setFont(new Font("",1,18));	
		JPanel phoneNumberTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		phoneNumberTextPanel.add(txtPhoneNumber);
		
		textPanel.add(phoneNumberTextPanel);
		
		txtCompany=new JTextField(10);
		txtCompany.setFont(new Font("",1,18));	
		JPanel companyNameTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		companyNameTextPanel.add(txtCompany);
		
		textPanel.add(companyNameTextPanel);
		
		txtSalary=new JTextField(10);
		txtSalary.setFont(new Font("",1,18));	
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		salaryTextPanel.add(txtSalary);
		
		textPanel.add(salaryTextPanel);
		
		txtBday=new JTextField(10);
		txtBday.setFont(new Font("",1,18));	
		JPanel bdayTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		bdayTextPanel.add(txtBday);
		
		textPanel.add(bdayTextPanel);
		
		add("Center",textPanel);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnBack = new JButton("Back To HomePage");
		btnBack.setFont(new Font("",1,16));	
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});		
	   
		buttonPanel.add(btnBack);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("",1,16));
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				int index = searchContact(txtId.getText());
				if(index!=-1){
				Contact[] tempContactArray = new Contact[Ifriendcontact.contactArray.length-1];
				for(int i = index;i<Ifriendcontact.contactArray.length-1;i++){
					Ifriendcontact.contactArray[i] = Ifriendcontact.contactArray[i+1];
				}
				for (int i = 0; i <tempContactArray.length; i++)
				{
					tempContactArray[i] = Ifriendcontact.contactArray[i];
				}
				Ifriendcontact.contactArray = tempContactArray;
				JOptionPane.showMessageDialog(null,"Delecte Success!...");	
			}
			
			else{
			JOptionPane.showMessageDialog(null," is not exists...");	
			}
		}
			
				
					
			
		});		
	   
		buttonPanel.add(btnDelete);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,16));	
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtName.setText("");
				txtPhoneNumber.setText("");
				txtCompany.setText("");
				txtSalary.setText("");
				txtBday.setText("");
			}
		});		
		buttonPanel.add(btnCancel);
		
		add("South",buttonPanel);
		
		
		}
		
		
		
		private int searchContact(String txt){
			for(int i = 0 ; i<txt.length();i++){
				if(txt.equalsIgnoreCase(Ifriendcontact.contactArray[i].getPhoneNumber())){
					return i;
				}
				else if(txt.equalsIgnoreCase(Ifriendcontact.contactArray[i].getName())){
					return i;
				}
				else if(txt.equalsIgnoreCase(Ifriendcontact.contactArray[i].getID())){
					return i;
				}
				
			}
			return -1;
		}
	}
	//--------------------------------------------------------------View Contacts----------------------------------------------------------------
	
	class ViewContacts extends JFrame{
		private JButton btnName;
		private JButton btnSalary;
		private JButton btnBday;
		private JButton btnCancel;
		
		private JLabel titleLabel;
		
		
		ViewContacts(){
		setTitle("CONTACTS LIST");
		setSize(800,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);		
		setLayout(new BorderLayout());
		
		JPanel tittlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tittleLabel = new JLabel(" CONTACTS LIST");
		tittleLabel.setFont(new Font("",1,28));
		tittleLabel.setHorizontalAlignment(JLabel.CENTER);
		tittlePanel.add(tittleLabel);
		tittlePanel.setBackground(new Color(173, 216, 230));
		add("North", tittlePanel);
		
		JPanel btnPanel = new JPanel(new GridLayout(3,1));
		
		JPanel namebtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnName = new JButton("List By Name");
		btnName.setFont(new Font("",1,16));	
		btnName.setPreferredSize(new Dimension(300,100));
		btnName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ListByName().setVisible(true);
			}
		});		
	   
		namebtn.add(btnName);
		btnPanel.add(namebtn);
		
		JPanel salarybtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnSalary = new JButton("List By Salary");
		btnSalary.setFont(new Font("",1,16));	
		btnSalary.setPreferredSize(new Dimension(300,100));
		btnSalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ListBySalary().setVisible(true);
			}
		});	
	   
		salarybtn.add(btnSalary);
		btnPanel.add(salarybtn);
		
		JPanel bdaybtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnBday = new JButton("List By Birthday");
		btnBday.setPreferredSize(new Dimension(300,100));
		btnBday.setFont(new Font("",1,16));	
		btnBday.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ListByBday().setVisible(true);
			}
		});	
	   
		bdaybtn.add(btnBday);
		btnPanel.add(bdaybtn);
		
		add("Center",btnPanel);
		
		JPanel canclePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnCancel = new JButton("Back To HomePage");
		btnCancel.setFont(new Font("",1,16));	
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});		
	   
		canclePanel.add(btnCancel);
		add("South",canclePanel);
		
		
		
		
		
	}	
	}
    //---------------------------------------------------------------- List By Name------------------------------------------------------------
    class ListByName extends JFrame{
	private JButton btnReload;
	private JButton btnBack;
	
	private JTable tblContact;
	private DefaultTableModel dtm;
	
	ListByName(){
		setSize(800,600);
		setTitle("List By Name");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel tittlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tittleLabel = new JLabel("LIST BY NAME");
		tittleLabel.setFont(new Font("",1,28));
		tittleLabel.setHorizontalAlignment(JLabel.CENTER);
		tittlePanel.add(tittleLabel);
		tittlePanel.setBackground(new Color(173, 216, 230));
		add("North", tittlePanel);
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnReload = new JButton("Reload");
		btnReload.setFont(new Font("",1,16));	
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			sortByName();
			dtm.setRowCount(0);
				for (int i = 0; i < Ifriendcontact.contactArray.length; i++){
					Contact c1=Ifriendcontact.contactArray[i];
					Object[] rowData={c1.getID(),c1.getName(),c1.getPhoneNumber(),c1.getCompanyName(),c1.getSalary(),c1.getBday()};
					dtm.addRow(rowData);		
				}
			}
		});		
	   
		btnPanel.add(btnReload);
		
		
		btnBack = new JButton("Back To HomePage");
		btnBack.setFont(new Font("",1,16));	
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});		
	   
		btnPanel.add(btnBack);
		
		add("South",btnPanel);
		String[] columnName = {"Contact ID","Contact Name","Phone Number","Company  Name","Salary","Birth Day"};
		dtm=new DefaultTableModel(columnName,0);
		tblContact=new JTable(dtm);
		JScrollPane tablePanel=new JScrollPane(tblContact);
		add("Center",tablePanel);
		
		}
		
		public static void sortByName(){
			for(int i = Ifriendcontact.contactArray.length;i>0;i--){
				String maxName = Ifriendcontact.contactArray[0].getName();
				int index = 0;
				int result = 0;
				for(int j = 0;j<i;j++){
				    result = maxName.compareTo(Ifriendcontact.contactArray[j].getName());
					if(result<0){
						maxName=Ifriendcontact.contactArray[j].getName();
						index = j;
					}
				}
				Contact tempmax = Ifriendcontact.contactArray[index];
				Ifriendcontact.contactArray[index]=Ifriendcontact.contactArray[i-1];
				Ifriendcontact.contactArray[i-1] = tempmax;
			}

	}
}
    //--------------------------------------------------------------List By Salary------------------------------------------------------------
     class ListBySalary extends JFrame{
	private JButton btnReload;
	private JButton btnBack;
	
	private JTable tblContact;
	private DefaultTableModel dtm;
	
	ListBySalary(){
		setSize(800,600);
		setTitle("List By Salary");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel titleLabel=new JLabel("List By Salary");
		titleLabel.setFont(new Font("",1,28));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(new Color(173, 216, 230));
		add("North",titleLabel);
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnReload = new JButton("Reload");
		btnReload.setFont(new Font("",1,16));	
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			sortBySalary();
			dtm.setRowCount(0);
				for (int i = 0; i < Ifriendcontact.contactArray.length; i++){
					Contact c1=Ifriendcontact.contactArray[i];
					Object[] rowData={c1.getID(),c1.getName(),c1.getPhoneNumber(),c1.getCompanyName(),c1.getSalary(),c1.getBday()};
					dtm.addRow(rowData);		
				}
			}
		});		
	   
		btnPanel.add(btnReload);
		
		
		btnBack = new JButton("Back To HomePage");
		btnBack.setFont(new Font("",1,16));	
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});		
	   
		btnPanel.add(btnBack);
		
		add("South",btnPanel);
		String[] columnName = {"Contact ID","Contact Name","Phone Number","Company  Name","Salary","Birth Day"};
		dtm=new DefaultTableModel(columnName,0);
		tblContact=new JTable(dtm);
		JScrollPane tablePanel=new JScrollPane(tblContact);
		add("Center",tablePanel);
		
		}
		
		public static void sortBySalary(){
			for(int i = Ifriendcontact.contactArray.length;i>0;i--){
				double max = Ifriendcontact.contactArray[0].getSalary();
				int index = 0;
				for(int j = 0;j<i;j++){				 
					if(max<Ifriendcontact.contactArray[j].getSalary()){
						max=Ifriendcontact.contactArray[j].getSalary();
						index = j;
					}
				}
				Contact tempmax = Ifriendcontact.contactArray[index];
				Ifriendcontact.contactArray[index]=Ifriendcontact.contactArray[i-1];
				Ifriendcontact.contactArray[i-1] = tempmax;
			}

	}
}
   //--------------------------------------------------------------List By Birthday -----------------------------------------------------------
   class ListByBday extends JFrame{
	private JButton btnReload;
	private JButton btnBack;
	
	private JTable tblContact;
	private DefaultTableModel dtm;
	
	ListByBday(){
		setSize(800,600);
		setTitle("List By Birthday");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel tittlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tittleLabel = new JLabel(" LIST BY BIRTHDAY");
		tittleLabel.setFont(new Font("",1,28));
		tittleLabel.setHorizontalAlignment(JLabel.CENTER);
		tittlePanel.add(tittleLabel);
		tittlePanel.setBackground(new Color(173, 216, 230));
		add("North", tittlePanel);
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnReload = new JButton("Reload");
		btnReload.setFont(new Font("",1,16));	
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			sortByBday();
			dtm.setRowCount(0);
				for (int i = 0; i < Ifriendcontact.contactArray.length; i++){
					Contact c1=Ifriendcontact.contactArray[i];
					Object[] rowData={c1.getID(),c1.getName(),c1.getPhoneNumber(),c1.getCompanyName(),c1.getSalary(),c1.getBday()};
					dtm.addRow(rowData);		
				}
			}
		});		
	   
		btnPanel.add(btnReload);
		
		
		btnBack = new JButton("Back To HomePage");
		btnBack.setFont(new Font("",1,16));	
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});		
	   
		btnPanel.add(btnBack);
		
		add("South",btnPanel);
		String[] columnName = {"Contact ID","Contact Name","Phone Number","Company  Name","Salary","Birth Day"};
		dtm=new DefaultTableModel(columnName,0);
		tblContact=new JTable(dtm);
		JScrollPane tablePanel=new JScrollPane(tblContact);
		add("Center",tablePanel);
		
		}
		
		public static void sortByBday(){
			for(int i = Ifriendcontact.contactArray.length;i>0;i--){
				String maxBday = Ifriendcontact.contactArray[0].getBday();
				int index = 0;
				int result = 0;
				for(int j = 0;j<i;j++){
				    result = maxBday.compareTo(Ifriendcontact.contactArray[j].getBday());
					if(result<0){
						maxBday=Ifriendcontact.contactArray[j].getBday();
						index = j;
					}
				}
				Contact tempmax = Ifriendcontact.contactArray[index];
				Ifriendcontact.contactArray[index]=Ifriendcontact.contactArray[i-1];
				Ifriendcontact.contactArray[i-1] = tempmax;
			}

	}
}
   	
	//------------------------------------------------------------------------------Home Page -------------------------------------------------	
	class HomePage extends JFrame {
		

	
		private JButton btnAdd;
		private JButton btnupdate;
		private JButton btndelete;
		private JButton btnSearch;
		private JButton btnList;
		private JButton btnExit;
		
		private JLabel titleLabel;
		private JLabel titleLabel1;
		private JLabel HomeLabel;
		private JLabel pic;
		
		
		
		HomePage(){
			
		setTitle("IFRIEND CONTACT MANAGER");
		setSize(800,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);		
		setLayout(new BorderLayout());
		
		JPanel titlePanel=new JPanel(new GridLayout(2,2));
		
		titleLabel=new JLabel("IFRIEND");
		titleLabel.setFont(new Font("",1,24));
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		titlePanel.add(titleLabel);
		
		HomeLabel = new JLabel("HOME PAGE");
		HomeLabel.setFont(new Font("",1,24));
		HomeLabel.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(HomeLabel);
		
		titleLabel1=new JLabel("CONTACT MANAGER");
		titleLabel1.setFont(new Font("",1,24));
		titleLabel1.setHorizontalAlignment(JLabel.LEFT);
		titlePanel.add(titleLabel1);
		
		titlePanel.setBackground(new Color(173, 216, 230));
		add("North",titlePanel);
		
		
		 ImageIcon icon = new ImageIcon("D:\\ICM114\\ifriendcontact.png");
		 Image img = icon.getImage().getScaledInstance(400, 500, Image.SCALE_SMOOTH);
		 ImageIcon resizedIcon = new ImageIcon(img);
		 JLabel imgLabel = new JLabel(resizedIcon);
       
        
        add("West",imgLabel);
        
    	JPanel buttonPanel=new JPanel(new GridLayout(5,1));
		
		btnAdd=new JButton("Add New Contacts");
		btnAdd.setFont(new Font("",1,16));	
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new AddContactForm().setVisible(true);
			}
		});		
		buttonPanel.add(btnAdd);
		
		btnupdate=new JButton("Update Contacts");
		btnupdate.setFont(new Font("",1,16));	
		btnupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new Update().setVisible(true);
			}
		});	
		buttonPanel.add(btnupdate);
		
		btndelete=new JButton("Delete Contacts");
		btndelete.setFont(new Font("",1,16));	
		btndelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new DeleteContactsForm().setVisible(true);
			}
		});	
		buttonPanel.add(btndelete);
		
		btnSearch=new JButton("Search Contacts");
		btnSearch.setFont(new Font("",1,16));	
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new SearchContactForm().setVisible(true);
			}
		});		
		buttonPanel.add(btnSearch);
		
		btnList=new JButton("List Contacts");
		btnList.setFont(new Font("",1,16));	
		btnList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ViewContacts().setVisible(true);
			}
		});	
		buttonPanel.add(btnList);
		
		
		add("Center",buttonPanel);
		
		JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("",1,16));	
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});		
		exitPanel.add(btnExit);
		
		add("South",exitPanel);
		
		
		
		
		
		
		
	}
		
}
	
	
	class Ifriendcontact{
		
		public static Contact[] contactArray = new Contact[0];
		public static void main(String args[]){
			
			
			new HomePage().setVisible(true);
			
			}
		
		}
