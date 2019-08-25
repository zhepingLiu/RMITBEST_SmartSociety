<template>
  <div class="home">
    <div class="header flex jcfs">
      <div class="project-name fs20">智慧社区</div>
    </div>
    <div class="flex jcct">
      <el-tabs v-model="activeName" class="card-container">
        <el-tab-pane label="个人端" name="person">
          <person-tag></person-tag>
        </el-tab-pane>
        <el-tab-pane label="社区端" name="community">
          <community-tag></community-tag>
        </el-tab-pane>
        <el-tab-pane label="金融端" name="finance">
          <finance-tag></finance-tag>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
import PersonTag from '@/components/PersonTag'
import CommunityTag from '@/components/CommunityTag'
import FinanceTag from '@/components/FinanceTag'

export default {
  name: 'home',
  components: {
    'person-tag' : PersonTag,
    'community-tag' : CommunityTag,
    'finance-tag' : FinanceTag,
  },

  data() {
    return {
      activeName: 'person',
    }
  },
}
</script>
<style lang="less" scoped>
@borderWidth: 1px solid #eee;

  .header{
    height: 52px;
    background: #000;
  }

  .project-name{
    height: 52px;
    line-height: 52px;
    margin-left: 100px;
    background-image:-webkit-linear-gradient(bottom,rgb(19, 107, 196),rgb(227, 236, 245),rgb(8, 85, 161)); 
    -webkit-background-clip:text; 
    -webkit-text-fill-color:transparent;
  }

  .card-container{
    min-width: 1000px;
    // border: @borderWidth;
    min-height: 600px;
    margin-top: 20px;
}
</style>