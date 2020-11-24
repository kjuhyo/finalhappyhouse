import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

const SERVER_URL = 'http://localhost:8080/VueApi/api';

export default new Vuex.Store({
  state: {
    barColor: 'rgba(0, 0, 0, .8), rgba(0, 0, 0, .8)',
    barImage: 'https://demos.creative-tim.com/material-dashboard/assets/img/sidebar-1.jpg',
    drawer: null,
    accessToken: null,
    memId: "",
    memName: ""
  },
  getters: {
    getAccessToken(state) {
      return state.accessToken;
    },
    getmemId(state) {
      return state.memId;
    },
    getmemName(state) {
      return state.memName;
    }
  },
  mutations: {
    LOGIN(state, payload) {
      state.accessToken = payload["auth-token"];
      state.memId = payload["user-id"];
      state.memName = payload["user-name"];
    },
    LOGOUT(state) {
      state.accessToken = null;
      state.memId = "";
      state.memName = "";
    },
    SET_BAR_IMAGE (state, payload) {
      state.barImage = payload
    },
    SET_DRAWER (state, payload) {
      state.drawer = payload
    },
  },
  actions: {
    LOGIN(context, mem) {
      return axios
        .post(`${SERVER_URL}/user/confirm/login`, mem)
        .then((response) => {
          context.commit("LOGIN", response.data);
          axios.defaults.headers.common[
            "auth-token"
          ] = `${response.data["auth-token"]}`;
        });
    },
    LOGOUT(context) {
      context.commit("LOGOUT");
      axios.defaults.headers.common["auth-token"] = undefined;
    }
  },
  modules: {}
})
