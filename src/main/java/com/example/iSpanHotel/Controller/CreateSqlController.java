package com.example.iSpanHotel.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Class.BCrypt;
import com.example.iSpanHotel.Class.JWTutils;
import com.example.iSpanHotel.Class.Weather;
import com.example.iSpanHotel.Dao.HotelNewsDao;
import com.example.iSpanHotel.Dao.MemberDao;
import com.example.iSpanHotel.Dao.PermissionsDao;
import com.example.iSpanHotel.Dao.RoomDao;
import com.example.iSpanHotel.Dao.RoomTypeDao;
import com.example.iSpanHotel.model.HotelNews;
import com.example.iSpanHotel.model.Member;
import com.example.iSpanHotel.model.Permissions;
import com.example.iSpanHotel.model.Room;
import com.example.iSpanHotel.model.RoomType;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/createSql")
public class CreateSqlController {
	List<RoomType> roomTypes = new ArrayList<>();
	RoomType roomType1 = new RoomType();
	RoomType roomType2 = new RoomType();
	RoomType roomType3 = new RoomType();
	RoomType roomType4 = new RoomType();
	RoomType roomType5 = new RoomType();
	RoomType roomType6 = new RoomType();
	RoomType roomType7 = new RoomType();
	RoomType roomType8 = new RoomType();
	RoomType roomType9 = new RoomType();
	
	@Autowired
	private PermissionsDao permissionsDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private RoomTypeDao roomTypeDao;
	@Autowired
	private HotelNewsDao hotelNewsDao;
	@Autowired
	private RoomDao roomDao;
	
	@PostMapping("/member")
	private void member() {
		Member member1 = new Member();
		member1.setAccount("Twithe");
		member1.setPasswd(BCrypt.hashpw("Eibaiyexoh9I", BCrypt.gensalt()) );
		member1.setRealName("周杰倫");
		member1.setEmail("KarenRJennings@dayrep.com");
		member1.setTel("0962275261");
		memberDao.save(member1);
		
		Member member2 = new Member();
		member2.setAccount("Antouch");
		member2.setPasswd(BCrypt.hashpw("aaqu6IMoh", BCrypt.gensalt()));
		member2.setRealName("周興哲");
		member2.setEmail("DamionCCraig@rhyta.com");
		member2.setTel("0912439724");
		memberDao.save(member2);
		
		Member member3 = new Member();
		member3.setAccount("Clace1979");
		member3.setPasswd(BCrypt.hashpw("ahP6XahMoh", BCrypt.gensalt()));
		member3.setRealName("鄧紫棋");
		member3.setEmail("LatashaFHanley@armyspy.com");
		member3.setTel("0939416211");
		memberDao.save(member3);
		
		Member member4 = new Member();
		member4.setAccount("Vised1943");
		member4.setPasswd(BCrypt.hashpw("aeyieloo2Ae", BCrypt.gensalt()));
		member4.setRealName("韋禮安");
		member4.setEmail("AldenJPark@armyspy.com");
		member4.setTel("0939503316");
		memberDao.save(member4);
		
		Member member5 = new Member();
		member5.setAccount("Fraleve");
		member5.setPasswd(BCrypt.hashpw("iekohRah5oo", BCrypt.gensalt()));
		member5.setRealName("張惠妹");
		member5.setEmail("StephenLChong@armyspy.com");
		member5.setTel("0953115883");
		memberDao.save(member5);
		
		Member member6 = new Member();
		member6.setAccount("Boyaceing");
		member6.setPasswd(BCrypt.hashpw("Ieh8Ojein", BCrypt.gensalt()));
		member6.setRealName("梁靜茹");
		member6.setEmail("DudleyMNordin@armyspy.com");
		member6.setTel("0928269591");
		memberDao.save(member6);
		
		Member member7 = new Member();
		member7.setAccount("Raidearan79");
		member7.setPasswd(BCrypt.hashpw("nee9esiuJ5e", BCrypt.gensalt()));
		member7.setRealName("蔡依林");
		member7.setEmail("RicardoJGilliam@armyspy.com");
		member7.setTel("0921383622");
		memberDao.save(member7);
		
		Member member8 = new Member();
		member8.setAccount("Jecome");
		member8.setPasswd(BCrypt.hashpw("ohDa3Vogho", BCrypt.gensalt()));
		member8.setRealName("徐佳瑩");
		member8.setEmail("HaroldJBilger@rhyta.com");
		member8.setTel("0913852136");
		memberDao.save(member8);
		
		Member member9 = new Member();
		member9.setAccount("Lovid1942");
		member9.setPasswd(BCrypt.hashpw("pu0aiG5nei", BCrypt.gensalt()));
		member9.setRealName("林俊傑");
		member9.setEmail("PatriciaSCooke@armyspy.com");
		member9.setTel("0912345678");
		memberDao.save(member9);
		
		Member member10 = new Member();
		member10.setAccount("Priect");
		member10.setPasswd(BCrypt.hashpw("uo2ieThaena", BCrypt.gensalt()));
		member10.setRealName("陳奕迅");
		member10.setEmail("HaroldEGibbs@armyspy.com");
		member10.setTel("0953243243");
		memberDao.save(member10);
	}
	
	@PostMapping("/roomType")
	private void roomType() {
		roomType1.setRoomType("經濟雙人房");
		roomType1.setRoomPrice(2500);
		roomType1.setRoomPerson(2);
		roomType1.setRoomPic("https://images.pexels.com/photos/271639/pexels-photo-271639.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType1.setContent("房間面積為36平方米/383平方英尺。\r\n"
				+ "\r\n"
				+ "調高設計和超大窗戶使得房間充滿柔和的自然光線。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。");
		roomTypes.add(roomType1);
		roomTypeDao.save(roomType1);
		
		roomType2.setRoomType("經濟四人房");
		roomType2.setRoomPrice(4500);
		roomType2.setRoomPerson(4);
		roomType2.setRoomPic("https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType2.setContent("房間面積為60平方米/646平方英尺。\r\n"
				+ "\r\n"
				+ "調高設計和超大窗戶使得房間充滿柔和的自然光線。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。");
		roomTypes.add(roomType2);
		roomTypeDao.save(roomType2);
		
		roomType3.setRoomType("景觀雙人房");
		roomType3.setRoomPrice(3000);
		roomType3.setRoomPerson(2);
		roomType3.setRoomPic("https://images.pexels.com/photos/271618/pexels-photo-271618.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType3.setContent("房間面積為40平方米/349平方英尺。\r\n"
				+ "\r\n"
				+ "可飽覽壯麗的臺北101景觀或城市風光。\r\n"
				+ "\r\n"
				+ "寬敞的起居室配備沙發。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。\r\n"
				+ "\r\n"
				+ "獨立的玻璃淋浴間");
		roomTypes.add(roomType3);
		roomTypeDao.save(roomType3);
		
		roomType4.setRoomType("景觀四人房");
		roomType4.setRoomPrice(5500);
		roomType4.setRoomPerson(4);
		roomType4.setRoomPic("https://images.pexels.com/photos/279746/pexels-photo-279746.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType4.setContent("房間面積為60平方米/646平方英尺。\r\n"
				+ "\r\n"
				+ "可飽覽壯麗的臺北101景觀或城市風光。\r\n"
				+ "\r\n"
				+ "寬敞的起居室配備沙發。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。\r\n"
				+ "\r\n"
				+ "獨立的玻璃淋浴間");
		roomTypes.add(roomType4);
		roomTypeDao.save(roomType4);
		
		roomType5.setRoomType("豪華雙人房");
		roomType5.setRoomPrice(3500);
		roomType5.setRoomPerson(2);
		roomType5.setRoomPic("https://images.pexels.com/photos/1743229/pexels-photo-1743229.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType5.setContent("飽覽迷人的城市景觀。\r\n"
				+ "\r\n"
				+ "享受無線上網服務。\r\n"
				+ "\r\n"
				+ "房間面積為40平方米/349平方英尺。\r\n"
				+ "\r\n"
				+ "寬敞起居室配備沙發和躺椅。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。\r\n"
				+ "\r\n"
				+ "獨立淋浴間\r\n"
				+ "\r\n"
				+ "調高設計和超大窗戶使得房間充滿柔和的自然光線。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。");
		roomTypes.add(roomType5);
		roomTypeDao.save(roomType5);
		
		roomType6.setRoomType("豪華四人房");
		roomType6.setRoomPrice(6500);
		roomType6.setRoomPerson(4);
		roomType6.setRoomPic("https://images.pexels.com/photos/172872/pexels-photo-172872.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType6.setContent("飽覽迷人的城市景觀。\r\n"
				+ "\r\n"
				+ "享受無線上網服務。\r\n"
				+ "\r\n"
				+ "房間面積為56平方米/603平方英尺。\r\n"
				+ "\r\n"
				+ "寬敞起居室配備沙發和躺椅。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。\r\n"
				+ "\r\n"
				+ "獨立淋浴間\r\n"
				+ "\r\n"
				+ "調高設計和超大窗戶使得房間充滿柔和的自然光線。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。");
		roomTypes.add(roomType6);
		roomTypeDao.save(roomType6);
		
		roomType7.setRoomType("尊榮雙人房");
		roomType7.setRoomPrice(6000);
		roomType7.setRoomPerson(2);
		roomType7.setRoomPic("https://images.pexels.com/photos/97083/pexels-photo-97083.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType7.setContent("房間面積為72平方米/802平方英尺。\r\n"
				+ "\r\n"
				+ "飽覽臺北市的迷人全景。\r\n"
				+ "\r\n"
				+ "豪華的單臥室套房配備起居室、就餐區和小型廚房。\r\n"
				+ "\r\n"
				+ "寬敞的大理石浴室配有12寸純平電視、浴缸和獨立淋浴間。\r\n"
				+ "\r\n"
				+ "可享受豪華閣貴賓廊專屬服務及禮遇。\r\n"
				+ "\r\n"
				+ "享受無線上網服務。");
		roomTypes.add(roomType7);
		roomTypeDao.save(roomType7);
		
		roomType8.setRoomType("尊榮四人房");
		roomType8.setRoomPrice(11000);
		roomType8.setRoomPerson(4);
		roomType8.setRoomPic("https://images.pexels.com/photos/271672/pexels-photo-271672.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType8.setContent("房間面積為136平方米/1,463平方英尺。\r\n"
				+ "\r\n"
				+ "飽覽臺北市的迷人全景。\r\n"
				+ "\r\n"
				+ "豪華的單臥室套房配備起居室、就餐區和小型廚房。\r\n"
				+ "\r\n"
				+ "寬敞的大理石浴室配有12寸純平電視、浴缸和獨立淋浴間。\r\n"
				+ "\r\n"
				+ "可享受豪華閣貴賓廊專屬服務及禮遇。\r\n"
				+ "\r\n"
				+ "享受無線上網服務。");
		roomTypes.add(roomType8);
		roomTypeDao.save(roomType8);
		
		roomType9.setRoomType("總統套房");
		roomType9.setRoomPrice(20000);
		roomType9.setRoomPerson(4);
		roomType9.setRoomPic("https://images.pexels.com/photos/271619/pexels-photo-271619.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType9.setContent("房間面積為226平方米/2,432平方英尺。\r\n"
				+ "\r\n"
				+ "寬敞飄窗可飽覽臺北美妙絕倫的都市風光。\r\n"
				+ "\r\n"
				+ "豪華的單臥室套房配備起居室、就餐區和小型廚房。\r\n"
				+ "\r\n"
				+ "寬敞的浴室配備桑拿房和按摩浴缸。 管家服務。\r\n"
				+ "\r\n"
				+ "可享受豪華閣貴賓廊專屬服務及禮遇。\r\n"
				+ "\r\n"
				+ "享受無線上網服務。\r\n"
				+ "\r\n"
				+ "可享受豪華閣貴賓廊專屬服務及禮遇。");
		roomTypes.add(roomType9);
		roomTypeDao.save(roomType9);
	}
	
	@PostMapping("/hotelNews")
	private void hotelNews() {
		HotelNews hotelNew1 = new HotelNews();
		hotelNew1.setNewsType((short) 1);
		hotelNew1.setTitle("溫馨聖誕嘉年華");
		hotelNew1.setStartDate("2022-12-16");
		hotelNew1.setEndDate("2022-12-31");
		hotelNew1.setPic("https://tpe.fareasternhotel.com.tw/upload/catalog_news_b/twL_catalog_news_22L02_LaBnO907N3.png");
		hotelNew1.setContent("\"誠摯地邀請您與我們共度溫馨聖誕及歡樂新年！\r\n"
				+ "除了一系列豐富美食與慶祝活動外，在這美好的節日裡，歡迎您蒞臨\r\n"
				+ "飯店大廳感受充滿節慶氣氛的佈置以及繽紛童趣的旋轉木馬與聖誕市\r\n"
				+ "集，佳節期間亦特別設置了零錢捐款活動，您可選擇支持國際兒童村\r\n"
				+ "或新北市玩具銀行，和我們一起用實際行動傳遞愛與祝福，支持台灣\r\n"
				+ "需要幫助的團體！\r\n"
				+ "趕快來一趟，共度溫馨聖誕及歡樂新年！\r\n"
				+ "即日起至2023/01/03(二)\r\n"
				+ "凡上傳您與大廳上聖誕布置的合照至Instagram，並完成以下步驟：\r\n"
				+ "1.文中標記 #(帳號須公開)\r\n"
				+ "2.追蹤官方Instagram帳號@即可抽「下午茶兩客」\r\n"
				+ "我們將於2023/1/06(五)在臉書及Insagram公布幸運得獎者\"");
		hotelNewsDao.save(hotelNew1);
		
		HotelNews hotelNew2 = new HotelNews();
		hotelNew2.setNewsType((short) 2);
		hotelNew2.setTitle("奢旅漫遊 超值享受");
		hotelNew2.setStartDate("2023-01-01");
		hotelNew2.setEndDate("2023-01-10");
		hotelNew2.setPic("https://tpe.fareasternhotel.com.tw/upload/catalog_news_b/twL_catalog_news_21J27_E9ttWiGHON.jpg");
		hotelNew2.setContent("\"放鬆身心的奢華五星假期，需要慢慢感受！入住兩晚以上豪華房型享\r\n"
				+ "7折優惠；經濟套房享6折優惠！\r\n"
				+ "專案包含： \r\n"
				+ "入住兩晚以上豪華房型享7折優惠；經濟套房享6折優惠\r\n"
				+ "免費使用健身俱樂部及頂樓景觀恆溫泳池 \r\n"
				+ "含豪華禮遇，包含早餐、下午茶及雞尾酒時光\r\n"
				+ "\r\n"
				+ "條款及細則\r\n"
				+ "房價需加收10%服務費及5%稅金。\r\n"
				+ "敬請事先預訂，此優惠須視訂房時客房供應情況方可確認訂房。\r\n"
				+ "此專案內容之優惠恕不得與其它優惠或政府旅遊補助併用。\r\n"
				+ "飯店保留取消與修改專案優惠的權利。\r\n"
				+ "不適用日期:2022/1/31-2/5\r\n"
				+ "早餐、下午茶及雞尾酒時光場域需視當日住房率而定\"");
		hotelNewsDao.save(hotelNew2);
	}

	@PostMapping("/permissions")
	private void permissions() {
		Permissions permissions1 = new Permissions();
		permissions1.setPermission("member_manage");
		permissions1.setNote("會員管理");
		permissionsDao.save(permissions1);
		
		Permissions permissions2 = new Permissions();
		permissions2.setPermission("employee_manage");
		permissions2.setNote("員工管理");
		permissionsDao.save(permissions2);
		
		Permissions permissions3 = new Permissions();
		permissions3.setPermission("room_manage");
		permissions3.setNote("房間管理");
		permissionsDao.save(permissions3);
		
		Permissions permissions4 = new Permissions();
		permissions4.setPermission("roomtype_manage");
		permissions4.setNote("房型管理");
		permissionsDao.save(permissions4);
		
		Permissions permissions5 = new Permissions();
		permissions5.setPermission("news_manage");
		permissions5.setNote("消息管理");
		permissionsDao.save(permissions5);
		
		Permissions permissions6 = new Permissions();
		permissions6.setPermission("customer_service");
		permissions6.setNote("客服");
		permissionsDao.save(permissions6);
		
		Permissions permissions7 = new Permissions();
		permissions7.setPermission("manager");
		permissions7.setNote("管理者");
		permissionsDao.save(permissions7);
	}
	
	@PostMapping("/room")
	private void room() {
		for (int i = 11; i <= 20; i++) {
			if (i <=16) {
				Room room1 = new Room();
				room1.setRoomNum(i + "01");
				room1.setRoomFloor(i);
				room1.setRoomStatus((short)1);
				room1.setRoomType(roomType1);
				room1.setNote(null);
				roomDao.save(room1);
					
				Room room2 = new Room();
				room2.setRoomNum(i + "02");
				room2.setRoomFloor(i);
				room2.setRoomStatus((short)1);
				room2.setRoomType(roomType2);
				room2.setNote(null);
				roomDao.save(room2);
					
				Room room3 = new Room();
				room3.setRoomNum(i + "03");
				room3.setRoomFloor(i);
				room3.setRoomStatus((short)1);
				room3.setRoomType(roomType3);
				room3.setNote(null);
				roomDao.save(room3);
					
				Room room4 = new Room();
				room4.setRoomNum(i + "04");
				room4.setRoomFloor(i);
				room4.setRoomStatus((short)1);
				room4.setRoomType(roomType4);
				room4.setNote(null);
				roomDao.save(room4);
					
				Room room5 = new Room();
				room5.setRoomNum(i + "05");
				room5.setRoomFloor(i);
				room5.setRoomStatus((short)1);
				room5.setRoomType(roomType5);
				room5.setNote(null);
				roomDao.save(room5);
					
				Room room6 = new Room();
				room6.setRoomNum(i + "06");
				room6.setRoomFloor(i);
				room6.setRoomStatus((short)1);
				room6.setRoomType(roomType6);
				room6.setNote(null);
				roomDao.save(room6);
					
				Room room7 = new Room();
				room7.setRoomNum(i + "07");
				room7.setRoomFloor(i);
				room7.setRoomStatus((short)1);
				room7.setRoomType(roomType7);
				room7.setNote(null);
				roomDao.save(room7);
					
				Room room8 = new Room();
				room8.setRoomNum(i + "08");
				room8.setRoomFloor(i);
				room8.setRoomStatus((short)1);
				room8.setRoomType(roomType8);
				room8.setNote(null);
				roomDao.save(room8);
			}
			if (i > 16) {
				Room room9 = new Room();
				room9.setRoomNum(i + "VIP");
				room9.setRoomFloor(i);
				room9.setRoomStatus((short)1);
				room9.setRoomType(roomType9);
				room9.setNote(null);
				roomDao.save(room9);
			}
		}
		
	}

	@PostMapping("/testJWT")
	private void testJWT() {
		// 生成
		String token = JWTutils.creatJWT("測試", null);
		System.out.println("生成token=:" + token);
		// 解析
		try {
			Claims claims = JWTutils.parseJWT(token);
			System.out.println("解析成功" + claims.getSubject());
		} catch (Exception exception) {
			System.out.println("解析失敗:");
			exception.printStackTrace();
		}
	}
	
	@PostMapping("/weather")
	private void weather() {
		Weather.getWeather();
	}
}
