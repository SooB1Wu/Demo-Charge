import Vue from "vue";
import VueRouter from "vue-router";
import home from "@/components/home";
import pc from "@/components/pc";


Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: home
  },
  {
    path: "/pc",
    name: "pc",
    component: pc
  }

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
