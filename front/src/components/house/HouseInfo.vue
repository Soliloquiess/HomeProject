<template>
  <div>
    <div class="col-lg-12" style="margin-bottom:20px">
      <div class="col-lg-1"></div>
      <div class="col-lg-10" style="text-align:center">
        <div class="col-lg-6" style="border: 1px solid black;overflow-x:hidden; overflow-y:scroll; height:400px;">
          <div>
            <!-- style="display:inline"> -->
            <span>도/ 광역시 </span>
            <select v-model="sido" class="form-group" @change="sidoChange" style="width:100px">
              <option v-for="(sido, idx) in sidos" v-bind:value="sido" v-bind:key="idx">{{ sido.sidoName }}</option>
            </select>
            <span>시/구/군 </span>
            <select v-model="gugun" class="form-group" @change="gugunChange" style="width:80px">
              <option v-for="(gugun, idx) in guguns" v-bind:value="gugun" v-bind:key="idx">{{ gugun.gugunName }}</option>
            </select>
            <span>동 </span>
            <select v-model="dong" class="form-group" style="width:80px">
              <option v-for="(dong, idx) in dongs" v-bind:value="dong" v-bind:key="idx">{{ dong.dongName }}</option>
            </select> / 
            <input placeholder="아파트 명" @keydown.enter="dongChange" v-model="aptname" style="width:100px">
            <button @click="dongChange">검색</button>
            <div class="card shadow">
              <div class="card-body">
                <table class="table table-hover">
                  <thead>
                    <tr>
                      <th class="text-center d-none d-md-table-cell">번호</th>
                      <th class="text-center d-none d-md-table-cell">동</th>
                      <th class="text-center d-none d-md-table-cell">주택 이름</th>
                      <th class="text-center d-none d-md-table-cell">건설연도</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(item, index) in items" v-bind:key="index">
                      <td class="text-center d-none d-md-table-cell">
                        {{ item.no }}
                      </td>
                      <td class="text-center d-none d-md-table-cell">{{ item.dong }}</td>
                      <td class="text-center d-none d-md-table-cell">
                        <router-link :to="'houseinforead/' + item.no">
                          {{ item.aptName }}
                        </router-link>
                      </td>
                      <td class="text-center d-none d-md-table-cell">{{ item.buildYear }}</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-1"></div>
        <div class="col-lg-5" style="border: 1px solid black">
          <div id="map" style="height:400px;"/>
        </div>
      </div>
      <div class="col-lg-1"></div>
    </div>
    <div class="col-lg-12" style="margin-bottom:20px">
      <div class="col-lg-1"></div>
      <div class="col-lg-10" style="border: 1px solid black;overflow-x:hidden; overflow-y:scroll; height:400px;margin-bottom:20px">
          <div>
            <div class="card shadow">
              <div class="card-body">
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
                    <tr v-for="(deal, index) in dealInfo" v-bind:key="index">
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
      </div>
      <div class="col-lg-1"></div>
      <div class="col-lg-12" style="border:1px solid black;height:250px;display:inline-block;margin-bottom:20px">
        <div class="col-lg-2"></div>
        <div class="col-lg-8" style="border:1px solid black;height:250px">게시판 미리보기가 들어올곳입니다</div>
        <div class="col-lg-2"></div>
      </div> 
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Paginate from "vuejs-paginate";
import Vue from "vue";

Vue.component("paginate", Paginate);

export default {
  component:{
  },
  data() {
    return {
      items: [],
      page: 1,
      totalpages: 10,
      center: {
        lat: 37.5743822,
        lng: 126.9688505,
      },
      sidos: [],
      sido: {},
      guguns: [],
      gugun: {},
      dongs: [],
      dong: {},
      aptname:"",
      dealInfo:[]
    };
  },
  created() {
    this.addScript();
    axios.get("http://localhost/house/sido/")
        .then(( response ) => {
          this.sidos = response.data;
        })
  },
  mounted() {
    window.kakao && window.kakao.maps ? this.initMap() : this.addScript();
  },
  beforeUpdate() {
    this.initMap();
  },
  methods: {
    clickCallback(pageNum) {
      if (this.dong != "") {
        console.log(this.dong);
        this.dongChange();
      } else {
        console.log("none");
        axios.get("http://localhost:9999/happyhouse/houseinfo/all/" + pageNum).then(({ data }) => {
          console.log(data);
          this.items = data.data;
          this.center.lat = this.items[0].lat;
          this.center.lng = this.items[0].lng;

          this.initMap();
        });
      }
    },
    initMap() {
      let container = document.getElementById("map");
      let options = {
        center: new kakao.maps.LatLng(this.center.lat, this.center.lng),
        // center: new kakao.maps.LatLng(lat, lng),
        level: 3,
        // tileAnimation: false,
      };
      let map = new kakao.maps.Map(container, options);

      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

      //마커추가하려면 객체를 아래와 같이 하나 만든다.
      for (var i = 0; i < this.items.length; i++) {
        // 마커 이미지의 이미지 크기 입니다
        var imageSize = new kakao.maps.Size(24, 35);
        // 마커 이미지를 생성합니다
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

        // console.log(this.items[i].lat + "," + this.items[i].lng);
        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
          map: map, // 마커를 표시할 지도
          position: new kakao.maps.LatLng(this.items[i].lat, this.items[i].lng), // 마커를 표시할 위치
          title: this.items[i].aptName, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage, // 마커 이미지
        });
        marker.setMap(map);
      }
    },
    addScript() {
      const script = document.createElement("script");
      /* global kakao */ script.onload = () => kakao.maps.load(this.initMap);
      script.src = "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=ee8796f7267ad78a04e16e70d60e58a1&libraries=services,clusterer,drawing";
      document.head.appendChild(script);
    },
    sidoChange() {
      console.log(this.sido);
      axios
        .get("http://localhost/house/gugun?sido="+this.sido.sidoCode)
        .then((response) => {
          // console.log(data.data);
          this.guguns = response.data;
        })
        .catch((response) => {
          console.log(this.sido.sidoCode);
          console.log(response);
        });
    },
    gugunChange() {
      console.log(this.gugun);
      axios
        .get("http://localhost/house/dong?gugun="+this.gugun.gugunCode)
        .then((response) => {
          this.dongs = response.data;
        });
    },
    dongChange() {
      console.log(this.dong);
      console.log(this.aptname);
      if(this.aptname==""){
        axios
          .get("http://localhost/deal/"+this.dong.dongName)
          .then((response) => {
            this.dealInfo = response.data;
            console.log("this is deal");
            console.log(response.data);
        });  
        axios
          .get("http://localhost/house/info?dong="+this.dong.dongName)
          .then((response) => {
            this.items = response.data;
            console.log("in if");
            console.log(response.data[0].lat);
            this.center.lat = response.data[0].lat;
            this.center.lng = response.data[0].lng;
            this.initMap();
        });  
      }
      else{
        axios
          .get("http://localhost/house/infobyname?aptname="+this.aptname)
          .then((response) => {
            console.log(response.data);
            this.items = response.data;
            console.log(response.data[0].lat);
            this.center.lat = response.data[0].lat;
            this.center.lng = response.data[0].lng;
            this.initMap();
        }); 
        axios
          .post("http://localhost/deal/"+this.aptname)
          .then((response2) => {
            this.dealInfo = response2.data;
            console.log("this is deal");
            console.log(response2.data);
        }); 
      }
    },
  },
};
</script>

<style scoped>
</style>
