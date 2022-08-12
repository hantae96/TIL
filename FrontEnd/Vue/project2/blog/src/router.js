import { createWebHashHistory, createRouter } from "vue-router";
import ListPage from "./components/ListPage.vue"
import homePage from "./components/HomePage.vue"
import detailPage from "./components/DetailPage.vue"
import notPage from "./components/NotPage.vue"
import Author from "./components/AuthorPage.vue"
import Comment from "./components/CommentPage.vue"

const routes = [
  {
    path: "/list",
    component: ListPage,
  },
  {
    path: "/",
    component : homePage,
  },
  {
    path: "/detail/:id(\\d+)",
    component : detailPage,
    children : [
        {
            path : "author",
            component:Author,
        },
        {
            path : "comment",
            component:Comment,
        }
    ]
  },
  {
    path: "/:anything(.*)",
    component : notPage,
  },




];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router; 