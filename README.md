# Smart Attendance Management System

A desktop-based Java application that automates the attendance tracking process using QR Code scanning and camera-based facial recognition.

## 📌 Project Overview

In today's fast-paced academic and professional environments, manual attendance methods are inefficient, error-prone, and outdated. The Smart Attendance Management System solves this by leveraging technology to streamline, secure, and simplify attendance.

Built using **Java (Swing/JFrame)** and **MySQL**, this application enables students to mark their attendance via:
- ✅ **QR Code Scanning**
- ✅ **Camera-based Face Recognition**

Administrators can manage users, courses, and generate attendance reports—all from a user-friendly dashboard.

---

## 🎯 Objectives

- 📷 Automate attendance using QR codes & camera
- 🔐 Prevent proxy attendance with biometric authentication
- 🕒 Real-time updates in the MySQL database
- 🌱 Environmentally friendly – no paper registers
- 💼 Admin-friendly dashboard for efficient management

---

## 🖥️ Project Category

**Desktop Application**

---

## 🛠️ Tools & Technologies Used

### 💻 Software
- **Programming Language**: Java
- **GUI Framework**: Java Swing (JFrame)
- **Database**: MySQL
- **IDE**: NetBeans
- **Database Tool**: MySQL Workbench

### 🧰 Hardware Requirements
- Processor: 1.6 GHz or faster
- RAM: 4 GB
- Disk Space: 10 GB free
- Display: 1024x768 or higher

---

## 🗃️ Database Structure

### `admin`
| Field         | Type        | Description         |
|---------------|-------------|---------------------|
| admin_id      | int(11)     | Admin ID            |
| admin_username| varchar(255)| Admin Name          |
| admin_pass    | varchar(255)| Admin Password      |

### `userattendance`
| Field       | Type        |
|-------------|-------------|
| userid      | int(11)     |
| date        | date        |
| checkin     | datetime    |
| checkout    | datetime    |
| workduration| varchar(255)|

### `userdetails`
| Field         | Type        | Description      |
|---------------|-------------|------------------|
| id            | int(11)     | User ID          |
| name          | varchar(255)| User Name        |
| gender        | varchar(50) | Gender           |
| email         | varchar(255)| Email            |
| contact       | varchar(20) | Contact Number   |
| address       | varchar(500)| Address          |
| state         | varchar(50) | State            |
| country       | varchar(50) | Country          |
| uniqueregid   | varchar(50) | Unique Reg. ID   |
| imagename     | varchar(50) | Image File Name  |

---

## 📈 Key Features

- Register, update, and delete users
- Generate & scan QR codes
- Facial recognition-based attendance
- Check-in and check-out with timestamps
- Admin panel with attendance reports
- Future-ready for mobile/GPS integration

---

## 🔮 Future Scope

- Mobile app integration
- Real-time notifications to parents/students
- GPS-based tracking
- Cloud storage
- AI-powered analytics
- Voice recognition
- Offline sync support
- Role-based access control

---

## 👩‍💻 Team Members

- **Miss Aarti Mallayya Swami**
- **Miss Dhanshri Prakash Ghadge**
- **Miss Sakshi Abaso Desai**

Under the guidance of:
**Prof. P. P. Patil**  
**Yashwantrao Mohite Institute of Management, Karad**  
**Bharati Vidyapeeth Deemed University, Pune**

---

## 📷 Screenshots

> Add some screenshots or screen recordings of your application UI here in your GitHub repo!

---

## 📜 License

This project is for academic use only. Contact the authors for permission if you want to use or extend this work.

