USE springbootdatajpasecurity

INSERT INTO location (location_id, location_name, remarks) VALUES
    ("CG", "Cau Giay", ""),
    ("HL", "Hoa Lac", ""),
    ("DN", "Da Nang", ""),
    ("QN", "Quy Nhon", ""),
    ("HCM", "Ho Chi Minh", "")

INSERT INTO class_admin_profile (class_admin_profile_id, account, date_of_birth, email, full_name, gender, phone, remarks) VALUES
    (1, "NgocNN1", '1995-10-13', "NgocNN@email.com", "Nguyen Nhu Ngoc", 1, "0937652189", ""),
    (2, "NhiLNA1", '1996-6-16', "NhiLNA@email.com", "Le Nguyen Ai Nhi", 1, "0937254689", ""),
    (3, "QuynhTNN1", '1997-11-21', "QuynhTNN@email.com", "Tran Ngoc Nhu Quynh", 1, "09637636189", ""),
    (4, "ThamLH1", '1994-9-25', "ThamLH@email.com", "Le Hong Tham", 1, "0934766589", ""),
    (5, "AnhDVQ1", '1994-4-12', "AnhDVQ@email.com", "Duong Vu Quynh Anh", 1, "0974554779", ""),
    (6, "NganNTK1", '1995-7-8', "NganNTK@email.com", "Nguyen Tran Kim Ngan", 1, "0936346768", ""),
    (7, "TranBNH1", '1995-7-8', "NganNTK@email.com", "Ho Ngoc Bao Tran", 1, "0936346768", "")
    
INSERT INTO subject_type (subject_type_id, subject_type_name, remarks) VALUES
    (1, "Organizational Overview & Culture", ""),
    (2, "Company Process", ""),
    (3, "Standard Process", ""),
    (4, "IT Technical", ""),
    (5, "Non-IT Technical", ""),
    (6, "Foreign Language", ""),
    (7, "Soft Skill", ""),
    (8, "Management", "")

INSERT INTO sub_subject_type (sub_subject_type_id, sub_subject_type_name, remarks) VALUES
    (1, "Cloud", ""),
    (2, "Big Data", ""),
    (3, "CAD", ""),
    (4, "CAE", ""),
    (5, "SAP", ""),
    (6, "IT General", ""),
    (7, "Test", ""),
    (8, "Others", "")

INSERT INTO delivery_type (delivery_type_id, delivery_type_name, remarks) VALUES
    (1, "Class", ""),
    (2, "Seminar", ""),
    (3, "Exam", ""),
    (4, "Contest", ""),
    (5, "Certificate", ""),
    (6, "Club", ""),
    (7, "OJT", ""),
    (8, "Others", "")

INSERT INTO format_type (format_type_id, format_type_name, remarks) VALUES
    (1, "Online", ""),
    (2, "Offline", ""),
    (3, "Blended", "")

INSERT INTO scope (scope_id, scope_name, remarks) VALUES
    (1, "Company", ""),
    (2, "Unit", ""),
    (3, "Outside", "")

INSERT INTO trainer_profile (trainer_profile_id, account, full_name, date_of_birth, email, experience, gender, major, phone, remarks, unit) VALUES
    (1, "MinhDV1", "Dang Van Minh", "1992-10-28", "MinhDV1@gmail.com", 4, 0, "Information Technology", "0538647284", "", ""),
    (2, "DungNH1", "Nguyen Hoang Dung", "1990-06-06", "DungNH1@gmail.com", 3, 0, "Computer Science", "053764t535", "", ""),
    (3, "LienDTM1", "Duong Thi My Lien", "1987-05-17", "LienDTM1@gmail.com", 6, 1, "Information Technology", "0575867654", "", ""),
    (4, "DungTV1", "Tran Van Dung", "1991-02-23", "DungTV1@gmail.com", 4, 0, "Computer Science", "0672437365", "", ""),
    (5, "HaiLH1", "Le Hoang Hai", "1989-08-12", "HaiLH1@gmail.com", 5, 0, "Information Technology", "0387654654", "", "")