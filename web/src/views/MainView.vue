<template>
  <a-layout id="outside-layout">
    <main-header-view />
    <a-layout>
      <main-sider-view />
      <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>Home</a-breadcrumb-item>
          <a-breadcrumb-item>List</a-breadcrumb-item>
          <a-breadcrumb-item>App</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            margin: 0,
            minHeight: '280px',
          }"
        >
          Content
        </a-layout-content>
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<script>
import { defineComponent, ref } from "vue";
import MainHeaderView from "@/views/MainHeaderView";
import MainSiderView from "@/views/MainSiderView";

export default defineComponent({
  components: {
    MainHeaderView,
    MainSiderView,
  },
  setup() {
    return {
      collapsed: ref(false),
    };
  },
});
</script>
<style>
#outside-layout .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}

.ant-row-rtl #outside-layout .logo {
  float: right;
  margin: 16px 0 16px 24px;
}
</style>
