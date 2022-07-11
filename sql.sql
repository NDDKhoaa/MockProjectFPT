USE `mockproject` ;

INSERT INTO `mockproject`.`location` (`location_id`, `location_name`, `remarks`) VALUES 
    ('HN', "Ha Noi", ""),
    ("CG", "Cau Giay", ""),
    ("HL", "Hoa Lac", ""),
    ("DN", "Da Nang", ""),
    ("QN", "Quy Nhon", ""),
    ("HCM", "Ho Chi Minh", "");

INSERT INTO `mockproject`.`faculty` (`faculty_id`, `faculty_name`) VALUES 
	('FL', 'Foreign Language'),
    ('MKT', 'Marketting'),
    ('BA', 'Business Administration'),
    ('TESOL', 'Teaching English to Speakers of Other Languages'),
    ('BM', 'Brand Management'),
    ('BE', 'Biomedical Engineering'),
    ('FB', 'Finance and Banking'),
    ('HRM', 'Human Resource Management'),
    ('IT', 'Information Technology');

INSERT INTO `mockproject`.`channel` (`channel_id`, `channel_name`) VALUES 
	('MAIL', 'Email Advertise'),
    ('WEB', 'Website Advertise'),
    ('FBOOK', 'Facebook Advertise'),
    ('INSTA', 'Instagram Advertise'),
    ('TV', 'Television Advertise'),
    ('NEWS', 'Newspaper Advertise');

INSERT INTO `mockproject`.`university` (`university_id`, `university_name`) VALUES 
	('VLU', 'Van Lang University'),
    ('HSU', 'Hoa Sen University'),
    ('SIU', 'Saigon Internation University'),
    ('VNU', 'Vietnam National University'),
    ('NEU', 'National Economics University'),
    ('FTU', 'Foreign Trade University'),
    ('USSH', 'University of Social Science & Humanities'),
    ('HNUE', 'Hanoi National University of Education'),
    ('UAF', 'University of Agriculture & Forestry'),
    ('FPT', 'FPT University');

INSERT INTO `mockproject`.`skill` (`skill_id`, `skill_name`) VALUES 
	('Java', 'Java '),
    ('SQL', 'SQL'),
    ('HTML/CSS', 'HTML/CSS'),
    ('C', 'C'),
    ('C#', 'C#'),
    ('Anguluar', 'Anguluar'),
    ('ReactJS', 'ReactJS'),
    ('JavaScript', 'JavaScript'),
    ('Python', 'Python');

INSERT INTO `mockproject`.`profile_status` (`profile_status_id`, `status`) VALUES 
	('New', 'New'),
    ('TP', 'Test - Pass'),
    ('TF', 'Test - Failed'),
    ('IP', 'Interview - Pass'),
    ('IF', 'Interview - Failed');


INSERT INTO `mockproject`.`profile_type` (`profile_status_id`, `type`) VALUES 
	('Candidate', 'Candidate'),
    ('Trainee', 'Trainee');
    
INSERT INTO `mockproject`.`class_admin_profile` (class_admin_profile_id, account, date_of_birth, email, full_name, gender, phone, remarks) VALUES
    (1, "NgocNN1", '1995-10-13', "NgocNN@email.com", "Nguyen Nhu Ngoc", 1, "0937652189", ""),
    (2, "NhiLNA1", '1996-6-16', "NhiLNA@email.com", "Le Nguyen Ai Nhi", 1, "0937254689", ""),
    (3, "QuynhTNN1", '1997-11-21', "QuynhTNN@email.com", "Tran Ngoc Nhu Quynh", 1, "09637636189", ""),
    (4, "ThamLH1", '1994-9-25', "ThamLH@email.com", "Le Hong Tham", 1, "0934766589", ""),
    (5, "AnhDVQ1", '1994-4-12', "AnhDVQ@email.com", "Duong Vu Quynh Anh", 1, "0974554779", ""),
    (6, "NganNTK1", '1995-7-8', "NganNTK@email.com", "Nguyen Tran Kim Ngan", 1, "0936346768", ""),
    (7, "TranBNH1", '1995-7-8', "NganNTK@email.com", "Ho Ngoc Bao Tran", 1, "0936346768", "");
    
INSERT INTO `mockproject`.`subject_type` (subject_type_id, subject_type_name, remarks) VALUES
    (1, "Organizational Overview & Culture", ""),
    (2, "Company Process", ""),
    (3, "Standard Process", ""),
    (4, "IT Technical", ""),
    (5, "Non-IT Technical", ""),
    (6, "Foreign Language", ""),
    (7, "Soft Skill", ""),
    (8, "Management", "");

INSERT INTO `mockproject`.`sub_subject_type` (sub_subject_type_id, sub_subject_type_name, remarks) VALUES
    (1, "Cloud", ""),
    (2, "Big Data", ""),
    (3, "CAD", ""),
    (4, "CAE", ""),
    (5, "SAP", ""),
    (6, "IT General", ""),
    (7, "Test", ""),
    (8, "Others", "");

INSERT INTO `mockproject`.`delivery_type` (delivery_type_id, delivery_type_name, remarks) VALUES
    (1, "Class", ""),
    (2, "Seminar", ""),
    (3, "Exam", ""),
    (4, "Contest", ""),
    (5, "Certificate", ""),
    (6, "Club", ""),
    (7, "OJT", ""),
    (8, "Others", "");

INSERT INTO `mockproject`.`format_type` (format_type_id, format_type_name, remarks) VALUES
    (1, "Online", ""),
    (2, "Offline", ""),
    (3, "Blended", "");

INSERT INTO `mockproject`.`scope` (scope_id, scope_name, remarks) VALUES
    (1, "Company", ""),
    (2, "Unit", ""),
    (3, "Outside", "");

INSERT INTO `mockproject`.`trainer_profile` (trainer_profile_id, account, full_name, date_of_birth, email, experience, gender, major, phone, remarks, unit) VALUES
    (1, "MinhDV1", "Dang Van Minh", "1992-10-28", "MinhDV1@gmail.com", 4, 0, "Information Technology", "0538647284", "", ""),
    (2, "DungNH1", "Nguyen Hoang Dung", "1990-06-06", "DungNH1@gmail.com", 3, 0, "Computer Science", "053764t535", "", ""),
    (3, "LienDTM1", "Duong Thi My Lien", "1987-05-17", "LienDTM1@gmail.com", 6, 1, "Information Technology", "0575867654", "", ""),
    (4, "DungTV1", "Tran Van Dung", "1991-02-23", "DungTV1@gmail.com", 4, 0, "Computer Science", "0672437365", "", ""),
    (5, "HaiLH1", "Le Hoang Hai", "1989-08-12", "HaiLH1@gmail.com", 5, 0, "Information Technology", "0387654654", "", "");
    
INSERT INTO `mockproject`.`trainee_candidate_profile` (trainer_profile_id, account, full_name, date_of_birth, email, experience, gender, major, phone, remarks, unit) VALUES
    (1, "MinhDV1", "Dang Van Minh", "1992-10-28", "MinhDV1@gmail.com", 4, 0, "Information Technology", "0538647284", "", ""),
    (2, "DungNH1", "Nguyen Hoang Dung", "1990-06-06", "DungNH1@gmail.com", 3, 0, "Computer Science", "053764t535", "", ""),
    (3, "LienDTM1", "Duong Thi My Lien", "1987-05-17", "LienDTM1@gmail.com", 6, 1, "Information Technology", "0575867654", "", ""),
    (4, "DungTV1", "Tran Van Dung", "1991-02-23", "DungTV1@gmail.com", 4, 0, "Computer Science", "0672437365", "", ""),
    (5, "HaiLH1", "Le Hoang Hai", "1989-08-12", "HaiLH1@gmail.com", 5, 0, "Information Technology", "0387654654", "", "");
    
INSERT INTO `mockproject`.`account` (`account_id`, `account`, `password`) VALUES 
('1', 'KhoaNDD', 'KhoaNDD'),
('2', 'RomanovN', 'RomanovN'),
('3', 'CarterP', 'CarterP'),
('4', 'StarkT', 'StarkT'),
('5', 'RogersS', 'RogersS');

INSERT INTO `mockproject`.`candidate` (`candidate_id`, `application_date`, `channel_id`, `location_id`, `status`) VALUES 
('1', '2022-11-07', 'INSTA', 'HCM', 'New'),
('2', '2022-11-07', 'FBOOK', 'HN', 'New'),
('3', '2022-11-07', 'NEWS', 'DN', 'New'),
('4', '2022-11-07', 'TV', 'CG', 'New'),
('5', '2022-11-07', 'MAIL', 'QN', 'New');

INSERT INTO `mockproject`.`cv` (`cv_id`, `name`, `size`, `trainee_candidate_profile_id`) VALUES 
('1', '', '0', '1'),
('2', '', '0', '2'),
('3', '', '0', '3'),
('4', '', '0', '4'),
('5', '', '0', '5');
INSERT INTO `mockproject`.`trainee_candidate_profile` (`trainee_candidate_profile_id`, `date_of_birth`, `email`, `foreign_language`, `full_name`, `gender`, `graduation_year`, `level`, `phone`, `account_account_id`, `candidate_candidate_id`, `cv_id`, `faculty_id`, `skill_id`, `type`, `university_id`) VALUES 
('1', '1998-08-24', 'nddkhoaa2408@gmail.com', 'English', 'Nguyen Do Dang Khoa', 'Male', '2020-08-01', 'Bachelor\'s Degree', '0929411586', '1', '1', '1', 'FL', 'Java', 'Candidate', 'VLU'),
('2', '1984-12-03', 'blackwidow@gmail.com', 'English,France,Italy', 'Natasha Romanov', 'Female', '2002-08-01', 'Bachelor\'s Degree', '0929411587', '2', '2', '2', 'FL', 'Java', 'Candidate', 'VLU'),
('3', '1921-04-09', 'agentpeggy@gmail.com', 'English', 'Peggy Carter', 'Male', '1945-08-01', 'Bachelor\'s Degree', '0929411588', '3', '3', '3', 'FL', 'Java', 'Candidate', 'VLU'),
('4', '1970-05-29', 'ironman@gmail.com', 'English', 'Tony Stark', 'Male', '1990-08-01', 'Bachelor\'s Degree', '0929411589', '4', '4', '4', 'FL', 'Java', 'Candidate', 'VLU'),
('5', '1918-07-04', 'captainamerica@gmail.com', 'English', 'Steve Rogers', 'Male', '2012-08-01', 'Bachelor\'s Degree', '0929411590', '5', '5', '5', 'FL', 'Java', 'Candidate', 'VLU');



INSERT INTO `mockproject`.`class_type` (class_type_id, class_type_name, remarks) VALUES
	('FR', 'Fresher', ""),
    ('CP', 'Campus Link', "");
    
INSERT INTO `mockproject`.`position` (position_id, position_name, remarks) VALUES
	('DEV', 'Developer', ""),
    ('TEST', 'Tester', ""),
    ('EMB', 'Embedded', ""),
    ('DOPS', 'DevOps', ""),
    ('DATA', 'Data Analysis', "");
    
    INSERT INTO `mockproject`.`roles` (role_id, name )VALUES
( 3, " FA. Manager"  ),
(4, " Delivery  Manager"  ),
(5 , "Class Admin"    ),
(6,  "FA. Rec"   ),
(18 , "Trainer" );


INSERT INTO `mockproject`.`role_privileges`(role_role_id , privileges )VALUES
(6,"ROLE_VIEW_TRAINER_PROFILE"),
(3, "ROLE_CREATE_CLASS"),
(5, "ROLE_VIEW_CLASS"),
(4, "ROLE_UPDATE_CLASS"),
(3, "ROLE_IMPORT_TRAINEE_TO_CLASS"),
(3, "ROLE_REMOVE_TRAINEE_FROM_CLASS"),
(3, "ROLE_SUBMIT_CLASS"),
(3, "ROLE_VIEW_CLASS"),
(3, "ROLE_ADD_TRAINEE_TO_CLASS"),
(3, "ROLE_CANCEL_CLASS"),
(3, "ROLE_UPDATE_CLASS"),
(3, "ROLE_SEARCH_CLASS"),
(4, "ROLE_CREATE_CLASS"),
(4, "ROLE_VIEW_TRAINER_PROFILE"),
(4, "ROLE_REMOVE_TRAINEE_FROM_CLASS"),
(4, "ROLE_CANCEL_CLASS"),
(4, "ROLE_DELETE_TRAINEE_PROFILE"),
(4, "ROLE_TRANSFER_CANDIDATE"),
(4, "ROLE_START_AN_ACCEPTED_CLASS"),
(4, "ROLE_FINISH_AN_IN_PROGRESS_CLASS"),
(4, "ROLE_REQUEST_FOR_MORE_INFORMATION"),
(4, "ROLE_APPROVE_A_SUBMITTED_CLASS"),
(4, "ROLE_REJECT_A_SUBMITTED_CLASS"),
(4, "ROLE_IMPORT_TRAINEE_TO_CLASS"),
(4, "ROLE_SEARCH_TRAINEE"),
(4, "ROLE_SUBMIT_CLASS"),
(4, "ROLE_UPDATE_TRAINEE_PROFILE"),
(4, "ROLE_VIEW_CLASS"),
(4, "ROLE_ADD_TRAINEE_TO_CLASS"),
(4, "ROLE_CLOSE_A_FINISHED_CLASS"),
(4, "ROLE_SEARCH_CLASS"),
(4, "ROLE_VIEW_CANDIDATE_DETAILS"),
(4, "ROLE_VIEW_TRAINEE_PROFILE"),
(3, "ROLE_VIEW_TRAINER_PROFILE"),
(3, "ROLE_UPDATE_CANDIDATE  "),
(3, "ROLE_CREATE_NEW_CANDIDATE_PROFILE" ),
(3, "ROLE_TRANSFER_CANDIDATE"),
(3, "ROLE_CREATE_TRAINER_PROFILE"),
(3, "ROLE_DELETE_TRAINER_PROFILE "),
(3, "ROLE_ACCEPT_AN_APPROVED_CLASS "),
(3, "ROLE_GENERATE_REPORT    "),
(3, "ROLE_REQUEST_FOR_MORE_INFORMATION "),
(3, "ROLE_REJECT_A_SUBMITTED_CLASS "),
(3, "ROLE_DECLINE_AN_APPROVED_CLASS"),
(3, "ROLE_SEARCH_TRAINEE   "),
(3, "ROLE_UPDATE_TRAINEE_PROFILE "),
(3, "ROLE_CLOSE_A_FINISHED_CLASS"),
(3, "ROLE_DELETE_CANDIDATE       "),
(3, "ROLE_VIEW_CANDIDATE_DETAILS "),
(3, "ROLE_VIEW_TRAINEE_PROFILE  "),
(3, "ROLE_DELETE_TRAINEE_PROFILE "),
(3, "ROLE_VIEW_REPORT     "),
(3, "ROLE_START_AN_ACCEPTED_CLASS"),
(3, "ROLE_FINISH_AN_IN_PROGRESS_CLASS"),
(3, "ROLE_APPROVE_A_SUBMITTED_CLASS"),
(3, "ROLE_EXPORT_REPORT       "),
(3, "ROLE_UPDATE_TRAINER_PROFILE  "),
(4, "ROLE_GENERATE_REPORT"),
(4, "ROLE_VIEW_REPORT "),
(4, "ROLE_EXPORT_REPORT  "),
(5, "ROLE_FINISH_AN_IN_PROGRESS_CLASS"),
(5, "ROLE_GENERATE_REPORT     "),
(5, "ROLE_VIEW_TRAINER_PROFILE  "),
(5, "ROLE_SUBMIT_CLASS "),
(5, "ROLE_UPDATE_TRAINEE_PROFILE "),
(5, "ROLE_EXPORT_REPORT   "),
(5, "ROLE_VIEW_REPORT "),
(5, "ROLE_SEARCH_CLASS    "),
(5, "ROLE_START_AN_ACCEPTED_CLASS "),
(5, "ROLE_VIEW_CANDIDATE_DETAILS"),
(5, "ROLE_UPDATE_TRAINER_PROFILE  "),
(6, "ROLE_UPDATE_CANDIDATE   "),
(6, "ROLE_VIEW_REPORT     "),
(6, "ROLE_CREATE_NEW_CANDIDATE_PROFILE" ),
(6, "ROLE_TRANSFER_CANDIDATE"),
(6, "ROLE_GENERATE_REPORT    "),
(6, "ROLE_VIEW_CLASS      "),
(6, "ROLE_EXPORT_REPORT  "),
(6, "ROLE_DELETE_CANDIDATE "),
(6, "ROLE_SEARCH_CLASS"),
(6, "ROLE_CANDIDATE_LISTING"),
(6, "ROLE_SEARCH_CANDIDATE"),
(6, "ROLE_VIEW_CANDIDATE_DETAILS"),
(6, "ROLE_VIEW_TRAINEE_PROFILE  "),
(18, "ROLE_VIEW_CLASS"),
(18, "ROLE_SEARCH_CLASS "),
(18, "ROLE_CANDIDATE_LISTING "),
(18, "ROLE_VIEW_CANDIDATE_DETAILS"),
(18, "ROLE_UPDATE_TRAINER_PROFILE"),
(18, "ROLE_VIEW_TRAINER_PROFILE "),
(18, "ROLE_GENERATE_REPORT"),
(18, "ROLE_VIEW_REPORT   "),
(18, "ROLE_EXPORT_REPORT");

SELECT * FROM class_admin_profile;

SELECT * FROM curriculumn;
SELECT * FROM budget;
SELECT * FROM audit;
SELECT * FROM trainer;
SELECT * FROM class_admin;
SELECT * FROM supplier_partner;
SELECT * FROM class_batch;

DELETE FROM curriculumn;
DELETE FROM budget;
DELETE FROM audit;
DELETE FROM trainer;
DELETE FROM class_admin;
DELETE FROM supplier_partner;
DELETE FROM class_batch where class_id in (31, 40);

DROP PROCEDURE UPDATE_CLASS_BATCH_STATUS;
DELIMITER $$
CREATE PROCEDURE UPDATE_CLASS_BATCH_STATUS (
	IN id BIGINT,
    IN status varchar(255),
    IN history varchar(255),
    IN remarks varchar(255),
    OUT row_cnt INT
)
BEGIN
	DECLARE classCreatedDate DATE default now();
    DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
		SET row_cnt = 0;
        ROLLBACK;
    END;
    START TRANSACTION;
		SET classCreatedDate = (SELECT created_date FROM class_batch WHERE class_id = id);
        IF classCreatedDate = null THEN SET classCreatedDate = now(); END IF;
		IF status = 'cancelled' AND datediff(now(), classCreatedDate) >= 1 THEN
			DELETE FROM curriculumn WHERE class_id = id;
 			DELETE FROM budget WHERE class_id = id;
 			DELETE FROM trainer WHERE class_id = id;
			DELETE FROM class_admin WHERE class_id = id;
 			DELETE FROM supplier_partner WHERE class_id = id;
 			DELETE FROM class_batch WHERE class_id = id;
            SELECT ROW_COUNT() INTO row_cnt;
		ELSE 
			UPDATE class_batch SET status = status, history = history, remarks = remarks
			WHERE class_id = id;
            SELECT ROW_COUNT() INTO row_cnt;
		END IF;
    COMMIT;
END$$

CALL UPDATE_CLASS_BATCH_STATUS (78, 'Submited', '06-Jul-2022 - Submited by anonymousUser', '', @row_cnt);
SELECT @row_cnt
SELECT * FROM class_batch;
