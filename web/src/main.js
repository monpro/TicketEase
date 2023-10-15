import { createApp } from "vue";
import Antd from "ant-design-vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "ant-design-vue/dist/antd.css";
import axios from "axios";

createApp(App).use(Antd).use(store).use(router).mount("#app");

axios.interceptors.request.use(
  function (config) {
    console.log("request config：", config);
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

axios.interceptors.response.use(
  function (response) {
    console.log("response：", response);
    return response;
  },
  (error) => {
    console.log("response error：", error);
    return Promise.reject(error);
  }
);
