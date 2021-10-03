// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
//导入路由组件
import router from './router'
//导入ElementUi
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

//导入axios
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.config.productionTip = false

//使用elementUI
Vue.use(ElementUI);
//使用axios
Vue.use(VueAxios, axios);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,//使用路由
  components: { App },
  template: '<App/>',
  render: h =>h(App)
})
