#CREATE DATABASE qlphongmayvalth CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use qlphongmayvalth;


create table QuyenTruyCap
(
	maQuyen bigint NOT NULL PRIMARY KEY auto_increment,
	tenQuyen VARCHAR(255) NOT NULL
);

create table GiaoVien
(
	maGV VARCHAR(255) NOT NULL PRIMARY KEY ,
	tenGV VARCHAR(255) NOT NULL,
	ngaySinh date,
	gioiTinh VARCHAR(5) ,
	email VARCHAR(255) NOT NULL,
	matkhau VARCHAR(255) NOT NULL,
	maQuyen bigint,
	trangThai int
	
);
ALTER TABLE GiaoVien ADD CONSTRAINT fk_gv_role FOREIGN KEY (maQuyen) REFERENCES QuyenTruyCap(maQuyen);

create table SinhVien
(
	maSV VARCHAR(255) NOT NULL PRIMARY KEY,
	tenSV VARCHAR(255) NOT NULL,
	namSinh date,
	gioiTinh VARCHAR(5),
	email VARCHAR(255) NOT NULL,
	matkhau VARCHAR(255) NOT NULL,
	maQuyen bigint,
	trangThai int
);
ALTER TABLE SinhVien ADD CONSTRAINT fk_sv_role FOREIGN KEY (maQuyen) REFERENCES QuyenTruyCap(maQuyen);	


create table CanBoQuanLy
(
	maCanBo VARCHAR(255) NOT NULL PRIMARY KEY,
	tenCanBo VARCHAR(255) NOT NULL,
	ngaySinh datetime ,
	gioiTinh VARCHAR(5) ,
	email VARCHAR(255) NOT NULL,
	matkhau VARCHAR(255) NOT NULL,
	maQuyen bigint,
	trangThai int
);
ALTER TABLE CanBoQuanLy ADD CONSTRAINT fk_cbql_role FOREIGN KEY (maQuyen) REFERENCES QuyenTruyCap(maQuyen);	


create table PhongMay
(
	maPhongMay VARCHAR(255) NOT NULL PRIMARY KEY,
	maCanBo VARCHAR(255),
	tinhTrang VARCHAR(255) NOT NULL,
	slMayChieu int,
	slDieuHoa int,
	slQuat int
);	


create table LopHocPhan
(
	maLHP VARCHAR(255) NOT NULL PRIMARY KEY ,
	tenLHP VARCHAR(255) NOT NULL,
	maGV VARCHAR(255)
);	

create table LichThucHanh
(
	maLHP VARCHAR(255) ,
	maPhongMay VARCHAR(255),
	thu VARCHAR(255) NOT NULL,
	tietBatDau int,
	tietKetThuc int,
	ngayHieuLuc date,
	primary key(maLHP,maPhongMay)
);	

create table ChiTietLHP
(
	maLHP VARCHAR(255),
	maSV VARCHAR(255),
	primary key(maLHP,maSV)
);


create table PhieuYeuCauPM
(
	maPhieuYC bigint NOT NULL PRIMARY KEY auto_increment,
	maGV VARCHAR(255),
	maPhongMay VARCHAR(255) NOT NULL,
	ngayGui date,
	ghiChu VARCHAR(255)
);	


create table ChiTietYC
(
	IDChiTiet bigint NOT NULL PRIMARY KEY auto_increment,
	maPhieuYC bigint,
	tenPhanMem VARCHAR(255) NOT NULL,
	linkFile VARCHAR(255),
	trangThai int,
	maCanBo VARCHAR(255) NULL
);
ALTER TABLE ChiTietYC ADD CONSTRAINT fk_ctyc_role FOREIGN KEY (maPhieuYC) REFERENCES PhieuYeuCauPM(maPhieuYC);
ALTER TABLE ChiTietYC ADD CONSTRAINT fk_ctyc_macb FOREIGN KEY (maCanBo) REFERENCES CanBoQuanLy(maCanBo);

INSERT INTO `qlphongmayvalth`.`quyentruycap` (`maQuyen`, `tenQuyen`) VALUES ('1', 'GiaoVien');
INSERT INTO `qlphongmayvalth`.`quyentruycap` (`maQuyen`, `tenQuyen`) VALUES ('2', 'CanBoQuanLy');
INSERT INTO `qlphongmayvalth`.`quyentruycap` (`maQuyen`, `tenQuyen`) VALUES ('3', 'SinhVien');

INSERT INTO `qlphongmayvalth`.`giaovien` (`maGV`, `tenGV`, `ngaySinh`, `gioiTinh`, `email`, `matkhau`, `maQuyen`, `trangThai`) VALUES ('5050001', 'Phạm Xuân Toán', '1992-05-08', 'Nam', 'pxt@gmail.com', '123', '1', '1');
INSERT INTO `qlphongmayvalth`.`giaovien` (`maGV`, `tenGV`, `ngaySinh`, `gioiTinh`, `email`, `matkhau`, `maQuyen`, `trangThai`) VALUES ('5050002', 'Nguyễn Phú Đồng', '1990-05-01', 'Nam', 'nguyenphudong@gmail.com', '123', '1', '1');
INSERT INTO `qlphongmayvalth`.`giaovien` (`maGV`, `tenGV`, `ngaySinh`, `gioiTinh`, `email`, `matkhau`, `maQuyen`, `trangThai`) VALUES ('5050003', 'Đỗ Thị Ngọc Lan', '1990-07-02', 'Nữ', 'dothilan@gmail.com', '123', '1', '1');
INSERT INTO `qlphongmayvalth`.`giaovien` (`maGV`, `tenGV`, `ngaySinh`, `gioiTinh`, `email`, `matkhau`, `maQuyen`, `trangThai`) VALUES ('5050004', 'Nguyễn Hồng Hạnh', '1994-07-04', 'Nữ', 'nguyenhanh@gmail.com', '123', '1', '1');


INSERT INTO `qlphongmayvalth`.`lophocphan` (`maLHP`, `tenLHP`, `maGV`) VALUES ('221TLTM01', 'TH Lập trình mạng', '5050002');
INSERT INTO `qlphongmayvalth`.`lophocphan` (`maLHP`, `tenLHP`, `maGV`) VALUES ('221TLTM02', 'TH Lập trình mạng', '5050002');
INSERT INTO `qlphongmayvalth`.`lophocphan` (`maLHP`, `tenLHP`, `maGV`) VALUES ('221TLTM03', 'TH Lập trình mạng', '5050002');
INSERT INTO `qlphongmayvalth`.`lophocphan` (`maLHP`, `tenLHP`, `maGV`) VALUES ('221TDHMT01', 'TH Đồ họa máy tính', '5050003');
INSERT INTO `qlphongmayvalth`.`lophocphan` (`maLHP`, `tenLHP`, `maGV`) VALUES ('221TDHMT02', 'TH Đồ họa máy tính', '5050003');
INSERT INTO `qlphongmayvalth`.`lophocphan` (`maLHP`, `tenLHP`, `maGV`) VALUES ('221TMMT01', 'TH Mạng Máy tính', '5050004');
INSERT INTO `qlphongmayvalth`.`lophocphan` (`maLHP`, `tenLHP`, `maGV`) VALUES ('221TCSDLI01', 'TH Cơ sở dữ liệu I', '5050004');
INSERT INTO `qlphongmayvalth`.`lophocphan` (`maLHP`, `tenLHP`, `maGV`) VALUES ('221TLTJNC01', 'TH Lập trình Java nâng cao', '5050004');
INSERT INTO `qlphongmayvalth`.`lophocphan` (`maLHP`, `tenLHP`, `maGV`) VALUES ('221TLTJNC02', 'TH Lập trình Java nâng cao', '5050001');

INSERT INTO `qlphongmayvalth`.`phongmay` (`maPhongMay`, `maCanBo`, `tinhTrang`, `slMayChieu`, `slDieuHoa`, `slQuat`) VALUES ('PMT01', 'CB001', '1', '1', '1', '4');
INSERT INTO `qlphongmayvalth`.`phongmay` (`maPhongMay`, `maCanBo`, `tinhTrang`, `slMayChieu`, `slDieuHoa`, `slQuat`) VALUES ('PMT02', 'CB002', '1', '1', '2', '4');
INSERT INTO `qlphongmayvalth`.`phongmay` (`maPhongMay`, `maCanBo`, `tinhTrang`, `slMayChieu`, `slDieuHoa`, `slQuat`) VALUES ('PMT03', 'CB002', '1', '1', '1', '3');
INSERT INTO `qlphongmayvalth`.`phongmay` (`maPhongMay`, `maCanBo`, `tinhTrang`, `slMayChieu`, `slDieuHoa`, `slQuat`) VALUES ('PMT04', 'CB003', '1', '1', '2', '3');
INSERT INTO `qlphongmayvalth`.`phongmay` (`maPhongMay`, `maCanBo`, `tinhTrang`, `slMayChieu`, `slDieuHoa`, `slQuat`) VALUES ('PMT05', 'CB003', '1', '1', '2', '3');


INSERT INTO `qlphongmayvalth`.`lichthuchanh` (`maLHP`, `maPhongMay`, `thu`, `tietBatDau`, `tietKetThuc`, `ngayHieuLuc`) VALUES ('221TCSDLI01', 'PMT01', '2', '1', '2', '');
INSERT INTO `qlphongmayvalth`.`lichthuchanh` (`maLHP`, `maPhongMay`, `thu`, `tietBatDau`, `tietKetThuc`, `ngayHieuLuc`) VALUES ('221TDHMT01', 'PMT02', '2', '1', '2', '');
INSERT INTO `qlphongmayvalth`.`lichthuchanh` (`maLHP`, `maPhongMay`, `thu`, `tietBatDau`, `tietKetThuc`, `ngayHieuLuc`) VALUES ('221TDHMT02', 'PMT03', '7', '1', '2', '');
INSERT INTO `qlphongmayvalth`.`lichthuchanh` (`maLHP`, `maPhongMay`, `thu`, `tietBatDau`, `tietKetThuc`, `ngayHieuLuc`) VALUES ('221TLTJNC01', 'PMT02', '4', '1', '2', '');
INSERT INTO `qlphongmayvalth`.`lichthuchanh` (`maLHP`, `maPhongMay`, `thu`, `tietBatDau`, `tietKetThuc`, `ngayHieuLuc`) VALUES ('221TLTM01', 'PMT05', '5', '3', '4', '');
INSERT INTO `qlphongmayvalth`.`lichthuchanh` (`maLHP`, `maPhongMay`, `thu`, `tietBatDau`, `tietKetThuc`, `ngayHieuLuc`) VALUES ('221TLTM02', 'PMT04', '6', '7', '8', '');
INSERT INTO `qlphongmayvalth`.`lichthuchanh` (`maLHP`, `maPhongMay`, `thu`, `tietBatDau`, `tietKetThuc`, `ngayHieuLuc`) VALUES ('221TLTM03', 'PMT02', '5', '9', '10', '');
INSERT INTO `qlphongmayvalth`.`lichthuchanh` (`maLHP`, `maPhongMay`, `thu`, `tietBatDau`, `tietKetThuc`, `ngayHieuLuc`) VALUES ('221TMMT01', 'PMT01', '2', '9', '10', '');






INSERT INTO phieuyeucaupm(maGV,maPhongMay,ngayGui,ghiChu) VALUES('5050001','PMT01','2022-06-20','');
INSERT INTO chitietyc(maPhieuYC,tenPhanMem,linkFile,trangThai) VALUES('1','Photohop CC','https://download.com.vn/adobe-photoshop-43801','1');
INSERT INTO phieuyeucaupm(maGV,maPhongMay,ngayGui,ghiChu) VALUES('5050001','PMT02','2022-06-21','');
INSERT INTO chitietyc(maPhieuYC,tenPhanMem,linkFile,trangThai) VALUES('2','Auto Card 2018','','1');
INSERT INTO chitietyc(maPhieuYC,tenPhanMem,linkFile,trangThai) VALUES('2','Netbean 2022','','0');
INSERT INTO phieuyeucaupm(maGV,maPhongMay,ngayGui,ghiChu) VALUES('5050002','PMT04','2022-06-22','mo file html');
INSERT INTO chitietyc(maPhieuYC,tenPhanMem,linkFile,trangThai) VALUES('3','Notepad++','https://notepad-plus-plus.org/downloads/','0');
INSERT INTO phieuyeucaupm(maGV,maPhongMay,ngayGui,ghiChu) VALUES('5050001','PMT05','2022-06-23','mo file html');
INSERT INTO chitietyc(maPhieuYC,tenPhanMem,linkFile,trangThai) VALUES('4','Notepad++','https://notepad-plus-plus.org/downloads/','0');

