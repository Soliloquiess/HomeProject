<template>
  <div>
    <div class="col-lg-1"></div>
    <div class="col-lg-6">
      <div class="card shadow" style="margin-bottom:20px">
        <h4>{{ houseinfo.aptName }}</h4><br>
        <div class="card-body" style="border:1px solid black;margin-bottom:20px"><br>
          <ul style="text-align:left">
            <li>행정동 : {{ houseinfo.dong }}</li>
            <li>지번 : {{ houseinfo.jibun }}</li>
            <li>건축시기 : {{ houseinfo.buildYear }}</li>
          </ul>
        </div>
        <div class="card-body" style="border: 1px solid black;overflow-x:hidden; overflow-y:scroll; height:330px;">
          <table class="table table-hover">
            <thead>
              <tr>
                <th class="text-center d-none d-md-table-cell">동</th>
                <th class="text-center d-none d-md-table-cell">주택 이름</th>
                <th class="text-center d-none d-md-table-cell">건설연도</th>
                <th class="text-center d-none d-md-table-cell">주택 층</th>
                <th class="text-center d-none d-md-table-cell">주택 면적</th>
                <th class="text-center d-none d-md-table-cell">거래 날짜</th>
                <th class="text-center d-none d-md-table-cell">거래 가격</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(deal, index) in dealinfo" v-bind:key="index">
                <td class="text-center d-none d-md-table-cell">{{ deal.dong }}</td>
                <td class="text-center d-none d-md-table-cell">{{ deal.aptName }}</td>
                <td class="text-center d-none d-md-table-cell">{{ deal.buildYear }}</td>
                <td class="text-center d-none d-md-table-cell">{{ deal.floor }}</td>
                <td class="text-center d-none d-md-table-cell">{{ deal.area }}</td>
                <td class="text-center d-none d-md-table-cell">{{deal.dealMonth}}월 {{deal.dealDay}}일</td>
                <td class="text-center d-none d-md-table-cell">{{ deal.dealAmount }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <div class="col-lg-5" id="map" style="width:500px;height:500px;"></div>
    <div class="col-lg-12" style="border:1px solid black;height:250px;display:inline-block;margin-bottom:20px">      
      <div class="col-lg-2"></div>
      <div class="col-lg-8" style="border:1px solid black;height:250px">그래프가 들어올곳입니다</div>
      <div class="col-lg-2"></div>
    </div> 
    <div class="col-lg-12" style="border:1px solid black;height:250px;display:inline-block;margin-bottom:20px">
      <div class="col-lg-2"></div>
      <div class="col-lg-8" style="border:1px solid black;height:250px">게시판 미리보기가 들어올곳입니다</div>
      <div class="col-lg-2"></div>
    </div> 
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      houseinfo: {},
      dealinfo:[],
      location: "",
      center: {
        lat: 37.5743822,
        lng: 126.9688505,
      },
      address: "",
      map: {},
      container: {},
      options: {},
      markers: [],
      marker: {},
      infowindows: [],
      infowindow: {},
      img: "../../image/default.jpg",
    };
  },
  created() {
    console.log("read:" + this.$route.params.no);
    axios.get("http://localhost/house/infobyno/" + this.$route.params.no).then(({ data }) => {
      console.log(data);
      this.houseinfo = data;
      console.log(this.houseinfo);
      this.center.lat = this.houseinfo.lat;
      this.center.lng = this.houseinfo.lng;
      this.img = this.houseinfo.img;
      this.searchDetailAddrFromCoords({ lng: this.houseinfo.lng, lat: this.houseinfo.lat }, this.setaddress);
    });
    
  },
  mounted() {
    window.kakao && window.kakao.maps ? this.initMap() : this.addScript();
  },
  beforeUpdate() {
    this.initMap();
    
    axios
      .post("http://localhost/deal/"+this.houseinfo.aptName)
      .then((response) => {        
        console.log(response);
        this.dealinfo = response.data;
      })
      .catch(()=>{
        console.log(this.houseinfo.aptName);
      });
  },
  methods: {
    searchPlace(place) {
      console.log(place);
      this.removeMarker();
      // 장소 검색 객체를 생성합니다
      var ps = new kakao.maps.services.Places(this.map);
      // 카테고리로 은행을 검색합니다
      ps.categorySearch(place, this.placesSearchCB, { useMapBounds: true });
    },
    placesSearchCB(data, status, pagination) {
      if (status === kakao.maps.services.Status.OK) {
        for (var i = 0; i < data.length; i++) {
          console.log(data[i]);
          this.displayMarker(data[i]);
        }
      }
    },
    displayMarker(place) {
      // var map = new kakao.maps.Map(mapContainer, mapOption);
      this.infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
      var infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
      // 마커를 생성하고 지도에 표시합니다
      this.marker = new kakao.maps.Marker({
        map: this.map,
        position: new kakao.maps.LatLng(place.y, place.x),
      });
      this.markers.push(this.marker);
      this.infowindows.push(this.infowindow);
      // 마커에 클릭이벤트를 등록합니다
      kakao.maps.event.addListener(this.marker, "click", function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        console.log("click");
        console.log(place.place_name);
        console.log(infowindow);
        console.log(place);
        alert("이름: " + place.place_name + "\n주소: " + place.address_name + "\n카테고리: " + place.category_name + "\n전화번호: " + place.phone);
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + "</div>");
        infowindow.open(this.map, this.marker);
      });
    },
    removeMarker() {
      for (var i = 0; i < this.markers.length; i++) {
        this.markers[i].setMap(null);
      }
      this.markers = [];
    },
    searchAddrFromCoords(lng, lat, setaddress) {
      // 좌표로 행  정동 주소 정보를 요청합니다
      // 주소-좌표 변환 객체를 생성합니다
      var geocoder = new kakao.maps.services.Geocoder();
      geocoder.coord2RegionCode(lng, lat, setaddress);
    },
    setaddress(result, status) {
      console.log({ result, status });
      if (status === kakao.maps.services.Status.OK) {
        this.location = result[0].address.address_name;
      } else {
        console.log("not ok");
      }
    },
    searchDetailAddrFromCoords(coords, callback) {
      // 좌표로 법정동 상세 주소 정보를 요청합니다
      // 주소-좌표 변환 객체를 생성합니다
      var geocoder = new kakao.maps.services.Geocoder();
      geocoder.coord2Address(coords.lng, coords.lat, callback);
    },

    initMap() {
      this.container = document.getElementById("map");
      this.options = {
        center: new kakao.maps.LatLng(this.center.lat, this.center.lng),
        // center: new kakao.maps.LatLng(lat, lng),
        level: 3,
        // tileAnimation: false,
      };
      this.map = new kakao.maps.Map(this.container, this.options);

      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

      //마커추가하려면 객체를 아래와 같이 하나 만든다.

      // 마커 이미지의 이미지 크기 입니다
      var imageSize = new kakao.maps.Size(24, 35);

      // 마커 이미지를 생성합니다
      var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

      // console.log(this.items[i].lat + "," + this.items[i].lng);
      // 마커를 생성합니다
      var marker = new kakao.maps.Marker({
        map: this.map, // 마커를 표시할 지도
        position: new kakao.maps.LatLng(this.houseinfo.lat, this.houseinfo.lng), // 마커를 표시할 위치
        title: this.houseinfo.aptName, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image: markerImage, // 마커 이미지
      });
      this.searchAddrFromCoords(this.houseinfo.lng, this.houseinfo.lat, null);
      marker.setMap(this.map);
    },
    addScript() {
      const script = document.createElement("script");
      /* global kakao */ script.onload = () => kakao.maps.load(this.initMap);
      script.src = "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=ee8796f7267ad78a04e16e70d60e58a1&libraries=services,clusterer,drawing";
      document.head.appendChild(script);
    },
  },
};
</script>

<style scoped>
.inline {
  display: inline;
}
.inline > img {
  width: 70px;
  height: 70px;
  margin: 5px;
}
.aptimg {
  height: 200px;
  width: 300px;
}
</style>
