import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

window.Kakao.init('e1c27a918a17f2abf789b134462dbe08');

Vue.config.productionTip = false;

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");
