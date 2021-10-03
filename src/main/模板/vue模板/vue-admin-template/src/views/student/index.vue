<template>
  <div class="app-container">
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="序号" width="95">
        <!-- slot-scope : 插槽
            scope : 当前行对象的引用
        -->
        <template slot-scope="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column label="ID" width="95">
        <template slot-scope="scope">
          <!--  scope.row : 获取当前行数据 -->
          {{ scope.row.stuId }}
        </template>
      </el-table-column>

      <el-table-column label="学号" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.stuNo }}</span>
        </template>
      </el-table-column>
      <el-table-column label="姓名" width="150" align="center">
        <template slot-scope="scope">
          {{ scope.row.stuName }}
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="性别" width="95" align="center">
        <template slot-scope="scope">
          {{ scope.row.gender == 0 ? '女' : '男' }}
        </template>
      </el-table-column>
      <!--<el-table-column align="center" prop="created_at" label="Display_time" width="200">
        <template slot-scope="scope">
          <i class="el-icon-time" />
          <span>{{ scope.row.display_time }}</span>
        </template>
      </el-table-column>-->
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="fetchData" />

  </div>
</template>

<script>
import Pagination from '@/components/Pagination'

export default {
  components: { Pagination },
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: null,
      listLoading: true,
      total: 0,
      listQuery: {
        page: 1,
        limit: 5
      }
    }
  },
  //钩子页面，vue对象创建完成后会被调用
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {

      //向后台发送ajax请求
      /*var url = "http://localhost:80/student/list";
      this.axios.get(url).then( res => {
        this.list = res.data.data;
        console.log(this.list);
        //不要加载图标
        this.listLoading = false;
      });*/

      var url = "http://localhost:80/student/page/" + this.listQuery.page + "/" + this.listQuery.limit;
      this.axios.get(url).then( res => {
        let vo = res.data;
        this.list = vo.data.records;
        this.total = vo.data.total;
        console.log(this.list);
        //不要加载图标
        this.listLoading = false;
      });

      /*getList().then(response => {
        this.list = response.data.items;
        this.listLoading = false;
      })*/
    }
  }
}
</script>
